package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.AttributiRuoliQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.AttributiRuoliFilter;
import com.retexspa.xr.ms.iam.main.core.responses.attributiRuoli.AttributiRuoliResponse;
import com.retexspa.xr.ms.iam.main.query.entities.AttributiRuoliQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.AttributiRuoliQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.AttributiRuoliRepository;
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
public class AttributiRuoliQueryServiceImpl implements AttributiRuoliQueryService {

    @Autowired
    private AttributiRuoliRepository attributiRuoliRepository;

    @Autowired
    private AttributiRuoliQueryMapper attributiRuoliQueryMapper;

    @Override
    public Page<AttributiRuoliQueryEntity> searchQueryAttributiRuoli(GenericSearchRequest<AttributiRuoliFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();
        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {

                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null ?
                                (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC) :
                                Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "id")
                );
                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "id"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<AttributiRuoliQueryEntity>> specifications = new ArrayList<>();
        AttributiRuoliFilter filter = AttributiRuoliFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }
        if (filter.getAttributoruoloId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("attributoRuolo").get("id"), filter.getAttributoruoloId()));
        }
        if (filter.getRuoloId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("ruolo").get("id"), filter.getRuoloId()));
        }
        if (filter.getValore() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("valore")), "%" + filter.getValore().toUpperCase() + "%"));
        }
        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }
        Specification<AttributiRuoliQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);
        Page<AttributiRuoliQueryEntity> page = this.attributiRuoliRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public AttributiRuoliResponse searchAttributiRuoli(GenericSearchRequest<AttributiRuoliFilter> query) {

        AttributiRuoliResponse attributiRuoliResponse = new AttributiRuoliResponse();
        Page<AttributiRuoliQueryEntity> page = searchQueryAttributiRuoli(query);
        List<AttributiRuoliQueryDTO> list = page.getContent().stream()
                .map(entity -> attributiRuoliQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        attributiRuoliResponse.setRecords(list);

        attributiRuoliResponse.setPagination(Pagination.buildPagination(page));

        return attributiRuoliResponse;
    }  
   
}
