package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.BadgeSocietaQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.BadgeSocietaFilter;
import com.retexspa.xr.ms.iam.main.core.responses.badgeSocieta.BadgeSocietaResponse;
import com.retexspa.xr.ms.iam.main.query.entities.BadgeSocietaQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.BadgeSocietaQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.BadgeSocietaRepository;
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
public class BadgeSocietaQueryServiceImpl implements BadgeSocietaQueryService {

    @Autowired
    private BadgeSocietaRepository badgeSocietaRepository;

    @Autowired
    private BadgeSocietaQueryMapper badgeSocietaQueryMapper;

    @Override
    public Page<BadgeSocietaQueryEntity> searchQueryBadgeSocieta(GenericSearchRequest<BadgeSocietaFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();
        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {

                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null ?
                                (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC) :
                                Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "codiceBadge")
                );
                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "codiceBadge"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<BadgeSocietaQueryEntity>> specifications = new ArrayList<>();

        BadgeSocietaFilter filter = BadgeSocietaFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }
        if (filter.getPwd() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("pwd")), "%" + filter.getPwd().toUpperCase() + "%"));
        }
        if (filter.getCodiceBadge() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("codiceBadge")), "%" + filter.getCodiceBadge().toUpperCase() + "%"));
        }
        if (filter.getSocietaId() != null) {
                    specifications.add((r, q, c) -> c.equal(r.get("societa").get("id"), filter.getSocietaId()));
        }
        if (filter.getTipoBadge() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("tipoBadge")), "%" + filter.getTipoBadge().toUpperCase() + "%"));
        }

        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }
        Specification<BadgeSocietaQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);
        Page<BadgeSocietaQueryEntity> page = this.badgeSocietaRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public BadgeSocietaResponse searchBadgeSocieta(GenericSearchRequest<BadgeSocietaFilter> query) {

        BadgeSocietaResponse badgeSocietaResponse = new BadgeSocietaResponse();
        Page<BadgeSocietaQueryEntity> page = searchQueryBadgeSocieta(query);
        List<BadgeSocietaQueryDTO> list = page.getContent().stream()
                .map(entity -> badgeSocietaQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        badgeSocietaResponse.setRecords(list);

        badgeSocietaResponse.setPagination(Pagination.buildPagination(page));

        return badgeSocietaResponse;
    }  
   
}
