package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.AttributiUtentiQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.AttributiUtentiFilter;
import com.retexspa.xr.ms.iam.main.core.responses.attributiUtenti.AttributiUtentiResponse;
import com.retexspa.xr.ms.iam.main.query.entities.AttributiUtentiQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.AttributiUtentiQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.AttributiUtentiRepository;
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
public class AttributiUtentiQueryServiceImpl implements AttributiUtentiQueryService {
    @Autowired
    private AttributiUtentiRepository attributiUtentiRepository;

    @Autowired
    private AttributiUtentiQueryMapper attributiUtentiQueryMapper;

    @Override
    public Page<AttributiUtentiQueryEntity> searchQueryAttributiUtenti(GenericSearchRequest<AttributiUtentiFilter> query) {
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

        List<Specification<AttributiUtentiQueryEntity>> specifications = new ArrayList<>();

        AttributiUtentiFilter filter = AttributiUtentiFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getValore() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("valore")), "%" + filter.getValore().toUpperCase() + "%"));
        }

        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }

        if (filter.getUtenteApplicazioneId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("utenteApplicazione").get("id"), filter.getUtenteApplicazioneId()));
        }

        if (filter.getAttributoId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("attributoUtenti").get("id"), filter.getAttributoId()));
        }

        if (filter.getContestoId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("contestoApplicazione").get("id"), filter.getContestoId()));
        }

        Specification<AttributiUtentiQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<AttributiUtentiQueryEntity> page = this.attributiUtentiRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public AttributiUtentiResponse searchAttributiUtenti(GenericSearchRequest<AttributiUtentiFilter> filter) {

        AttributiUtentiResponse attributiUtentiResponse = new AttributiUtentiResponse();
        Page<AttributiUtentiQueryEntity> page = searchQueryAttributiUtenti(filter);
        List<AttributiUtentiQueryDTO> list = page.getContent().stream()
                .map(entity -> attributiUtentiQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        attributiUtentiResponse.setRecords(list);

        attributiUtentiResponse.setPagination(Pagination.buildPagination(page));

        return attributiUtentiResponse;
    }

}
