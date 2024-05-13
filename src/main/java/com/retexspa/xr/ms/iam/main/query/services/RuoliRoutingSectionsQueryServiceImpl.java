package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.RuoliRoutingSectionsQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.RuoliRoutingSectionsFilter;
import com.retexspa.xr.ms.iam.main.core.responses.ruoliRoutingSections.RuoliRoutingSectionsResponse;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliRoutingSectionsQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.RuoliRoutingSectionsQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.RuoliRoutingSectionsRepository;
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
public class RuoliRoutingSectionsQueryServiceImpl implements RuoliRoutingSectionsQueryService {

    @Autowired
    private RuoliRoutingSectionsRepository ruoliRoutingSectionsRepository;

    @Autowired
    private RuoliRoutingSectionsQueryMapper ruoliRoutingSectionsQueryMapper;

    @Override
    public Page<RuoliRoutingSectionsQueryEntity> searchQueryRuoliRoutingSections(GenericSearchRequest<RuoliRoutingSectionsFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {
                switch(baseSort.getOrderBy()){
                    case "id":
                        break;

                    case "ruoliRoutingId":
                        break;

                    case "routingSectionId":
                        break;

                    case "flgAttiva":
                        break;

                    case "flgReadonly":
                        break;

                    case "flgInsert":
                        break;

                    case "flgUpdate":
                        break;

                    case "flgDelete":
                        break;

                    case "version":
                        break;
                    default:
                        throw new IllegalArgumentException("Order by is not correct");
                }
                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null ?
                                (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC) :
                                Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "ruoliRoutingId")
                );

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "ruoliRoutingId"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<RuoliRoutingSectionsQueryEntity>> specifications = new ArrayList<>();
        RuoliRoutingSectionsFilter filter = RuoliRoutingSectionsFilter.createFilterFromMap(query.getFilter());
        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getRuoliRoutingId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("ruoliRouting").get("id"), filter.getRuoliRoutingId()));
        }
        if (filter.getRoutingSectionId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("routingSection").get("id"), filter.getRoutingSectionId()));
        }
        if (filter.getFlgAttiva() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgAttiva")), "%" + filter.getFlgAttiva().toUpperCase() + "%"));
        }
        if (filter.getFlgReadonly()!= null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgReadonly")), "%" + filter.getFlgReadonly().toUpperCase() + "%"));
        }
        if (filter.getFlgInsert()!= null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgInsert")), "%" + filter.getFlgInsert().toUpperCase() + "%"));
        }
        if (filter.getFlgUpdate()!= null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgUpdate")), "%" + filter.getFlgUpdate().toUpperCase() + "%"));
        }
        if (filter.getFlgDelete()!= null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgDelete")), "%" + filter.getFlgDelete().toUpperCase() + "%"));
        }
        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }

        Specification<RuoliRoutingSectionsQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<RuoliRoutingSectionsQueryEntity> page = this.ruoliRoutingSectionsRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public RuoliRoutingSectionsResponse searchRuoliRoutingSections(GenericSearchRequest<RuoliRoutingSectionsFilter> query) {

        RuoliRoutingSectionsResponse ruoliRoutingSectionsResponse = new RuoliRoutingSectionsResponse();
        Page<RuoliRoutingSectionsQueryEntity> page = searchQueryRuoliRoutingSections(query);
        List<RuoliRoutingSectionsQueryDTO> list = page.getContent().stream()
                .map(entity -> ruoliRoutingSectionsQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        ruoliRoutingSectionsResponse.setRecords(list);

        ruoliRoutingSectionsResponse.setPagination(Pagination.buildPagination(page));

        return ruoliRoutingSectionsResponse;
    }
}
