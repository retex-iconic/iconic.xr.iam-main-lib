package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.RoutingFilter;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.retexspa.xr.ms.iam.main.core.entities.RoutingQueryDTO;
import com.retexspa.xr.ms.iam.main.core.responses.routing.RoutingResponse;
import com.retexspa.xr.ms.iam.main.query.entities.RoutingQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.RoutingQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.RoutingRepository;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoutingQueryServiceImpl implements RoutingQueryService {

    @Autowired
    private RoutingRepository routingRepository;

    @Autowired
    private RoutingQueryMapper routingQueryMapper;

    @Override
    public Page<RoutingQueryEntity> searchQueryRouting(GenericSearchRequest<RoutingFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {

                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null ?
                                (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC) :
                                Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "routingCharId")
                );

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "routingCharId"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<RoutingQueryEntity>> specifications = new ArrayList<>();
        RoutingFilter filter = RoutingFilter.createFilterFromMap(query.getFilter());
        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getIconicApplicazioniId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("iconicApplicazioni").get("id"), filter.getIconicApplicazioniId()));
        }

        if (filter.getRoutingCharId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("routingCharId"), filter.getRoutingCharId()));
        }

        if (filter.getTitolo() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("titolo")), "%" + filter.getTitolo().toUpperCase() + "%"));
        }

        if (filter.getUrlLink() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("urlLink")), "%" + filter.getUrlLink().toUpperCase() + "%"));
        }
        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }
        if (filter.getSubtitolo() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("subtitolo")), "%" + filter.getSubtitolo().toUpperCase() + "%"));
        }
        if (filter.getIcone() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("icone")), "%" + filter.getIcone().toUpperCase() + "%"));
        }
        if (filter.getFlgGdpr() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgGdpr")), "%" + filter.getFlgGdpr().toUpperCase() + "%"));
        }
        if (filter.getNodoId() != null) {
            specifications.add(
                    (r, q, c) -> c.equal(r.get("nodo").get("id"), filter.getNodoId()));
        }
        Specification<RoutingQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<RoutingQueryEntity> page = this.routingRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public RoutingResponse searchRouting(GenericSearchRequest<RoutingFilter> query) {

        RoutingResponse routingResponse = new RoutingResponse();
        Page<RoutingQueryEntity> page = searchQueryRouting(query);
        List<RoutingQueryDTO> list = page.getContent().stream()
                // .map(entity -> modelMapper.map(entity, RoutingQueryDTO.class))
                .map(entity -> routingQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        routingResponse.setRecords(list);

        routingResponse.setPagination(Pagination.buildPagination(page));

        return routingResponse;
    }

}
