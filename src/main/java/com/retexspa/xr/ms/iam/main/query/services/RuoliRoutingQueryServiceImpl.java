package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.RuoliRoutingQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.RuoliRoutingFilter;
import com.retexspa.xr.ms.iam.main.core.responses.ruoliRouting.RuoliRoutingResponse;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliRoutingQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.RuoliRoutingQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.RuoliRoutingRepository;
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
public class RuoliRoutingQueryServiceImpl implements RuoliRoutingQueryService {

    @Autowired
    private RuoliRoutingRepository ruoliRoutingRepository;

    @Autowired
    private RuoliRoutingQueryMapper ruoliRoutingQueryMapper;

    @Override
    public Page<RuoliRoutingQueryEntity> searchQueryRuoliRouting(GenericSearchRequest<RuoliRoutingFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {
                switch(baseSort.getOrderBy()){
                    case "id":
                        break;

                    case "routingId":
                        break;

                    case "ruoloId":
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
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "routingId")
                );

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "routingId"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<RuoliRoutingQueryEntity>> specifications = new ArrayList<>();
        RuoliRoutingFilter filter = RuoliRoutingFilter.createFilterFromMap(query.getFilter());
        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getRoutingId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("routing").get("id"), filter.getRoutingId()));
        }
        if (filter.getRuoloId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("ruolo").get("id"), filter.getRuoloId()));
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

        Specification<RuoliRoutingQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<RuoliRoutingQueryEntity> page = this.ruoliRoutingRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public RuoliRoutingResponse searchRuoliRouting(GenericSearchRequest<RuoliRoutingFilter> query) {

        RuoliRoutingResponse ruoliRoutingResponse = new RuoliRoutingResponse();
        Page<RuoliRoutingQueryEntity> page = searchQueryRuoliRouting(query);
        List<RuoliRoutingQueryDTO> list = page.getContent().stream()
                .map(entity -> ruoliRoutingQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        ruoliRoutingResponse.setRecords(list);

        ruoliRoutingResponse.setPagination(Pagination.buildPagination(page));

        return ruoliRoutingResponse;
    }
}

