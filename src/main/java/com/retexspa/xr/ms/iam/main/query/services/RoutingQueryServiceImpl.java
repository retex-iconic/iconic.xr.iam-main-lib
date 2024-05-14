package com.retexspa.xr.ms.iam.main.query.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.retexspa.xr.ms.iam.main.core.entities.RoutingQueryDTO;
import com.retexspa.xr.ms.iam.main.core.responses.routing.RoutingResponse;
import com.retexspa.xr.ms.iam.main.core.searchRequest.RoutingSearchRequest;
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
    public Page<RoutingQueryEntity> searchQueryRouting(RoutingSearchRequest query) {
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

        if (query.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
        }

        if (query.getIconicApplicazioniId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("iconicApplicazioni").get("id"), query.getIconicApplicazioniId()));
        }

        if (query.getRoutingCharId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("routingCharId"), query.getRoutingCharId()));
        }

        if (query.getTitolo() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("titolo")), "%" + query.getTitolo().toUpperCase() + "%"));
        }

        if (query.getUrlLink() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("urlLink")), "%" + query.getUrlLink().toUpperCase() + "%"));
        }
        if (query.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), query.getVersion()));
        }
        if (query.getSubtitolo() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("subtitolo")), "%" + query.getSubtitolo().toUpperCase() + "%"));
        }
        if (query.getIcone() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("icone")), "%" + query.getIcone().toUpperCase() + "%"));
        }
        if (query.getFlgGdpr() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgGdpr")), "%" + query.getFlgGdpr().toUpperCase() + "%"));
        }
        if (query.getNodoId() != null) {
            specifications.add(
                    (r, q, c) -> c.equal(r.get("nodo").get("id"), query.getNodoId()));
        }
        Specification<RoutingQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<RoutingQueryEntity> page = this.routingRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public RoutingResponse searchRouting(RoutingSearchRequest query) {

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
