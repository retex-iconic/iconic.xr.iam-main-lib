package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.RoutingSectionsQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.MenuFilter;
import com.retexspa.xr.ms.iam.main.core.filterRequest.RoutingSectionsFilter;
import com.retexspa.xr.ms.iam.main.core.responses.routingSections.RoutingSectionsResponse;
import com.retexspa.xr.ms.iam.main.query.entities.RoutingSectionsQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.RoutingSectionsQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.RoutingSectionsRepository;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoutingSectionsQueryServiceImpl implements RoutingSectionsQueryService {

    @Autowired
    private RoutingSectionsRepository routingSectionsRepository;

    @Autowired
    private RoutingSectionsQueryMapper routingSectionsQueryMapper;

    @Override
    public Page<RoutingSectionsQueryEntity> searchQueryRoutingSections(GenericSearchRequest<RoutingSectionsFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {

                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null ?
                                (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC) :
                                Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "codice")
                );

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "codice"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<RoutingSectionsQueryEntity>> specifications = new ArrayList<>();
        RoutingSectionsFilter filter = RoutingSectionsFilter.createFilterFromMap(query.getFilter());
        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }
        if (filter.getRoutingId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("routing").get("id"), filter.getRoutingId()));
        }

        if (filter.getCodice() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("codice"), filter.getCodice()));
        }

        if (filter.getDescrizione() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
        }

        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }
        Specification<RoutingSectionsQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<RoutingSectionsQueryEntity> page = this.routingSectionsRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public RoutingSectionsResponse searchRoutingSections(GenericSearchRequest<RoutingSectionsFilter> query) {

        RoutingSectionsResponse routingSectionsResponse = new RoutingSectionsResponse();
        Page<RoutingSectionsQueryEntity> page = searchQueryRoutingSections(query);
        List<RoutingSectionsQueryDTO> list = page.getContent().stream()
                // .map(entity -> modelMapper.map(entity, RoutingSectionsQueryDTO.class))
                .map(entity -> routingSectionsQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        routingSectionsResponse.setRecords(list);

        routingSectionsResponse.setPagination(Pagination.buildPagination(page));

        return routingSectionsResponse;
    }

}
