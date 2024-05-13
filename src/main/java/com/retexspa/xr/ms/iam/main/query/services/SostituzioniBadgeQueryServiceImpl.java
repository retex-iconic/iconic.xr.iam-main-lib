package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.SostituzioniBadgeQueryDTO;
import com.retexspa.xr.ms.iam.main.core.responses.sostituzioniBadge.SostituzioniBadgeResponse;
import com.retexspa.xr.ms.iam.main.core.searchRequest.SostituzioniBadgeSearchRequest;
import com.retexspa.xr.ms.iam.main.query.entities.SostituzioniBadgeQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.SostituzioniBadgeQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.SostituzioniBadgeRepository;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
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
public class SostituzioniBadgeQueryServiceImpl implements SostituzioniBadgeQueryService{
    @Autowired
    private SostituzioniBadgeRepository sostituzioniBadgeRepository;

    @Autowired
    private SostituzioniBadgeQueryMapper sostituzioniBadgeQueryMapper;

    @Override
    public Page<SostituzioniBadgeQueryEntity> searchQuerySostituzioniBadge(SostituzioniBadgeSearchRequest query) {
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

        List<Specification<SostituzioniBadgeQueryEntity>> specifications = new ArrayList<>();

        if (query.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
        }
        if (query.getUtentiId() != null) {
            specifications.add((r, q, c) ->
                    c.equal(r.get("utenti").get("id"),  query.getUtentiId()));
        }
        if (query.getBadgeId() != null) {
            specifications.add((r, q, c) ->
                    c.equal(r.get("badge").get("id"),  query.getBadgeId()));
        }
        if (query.getDataAssegnazione() != null) {
            specifications.add((r, q, c) ->
                    c.equal(r.get("dataAssegnazione"),  query.getDataAssegnazione()));
        }
        if (query.getDataBlocco() != null) {
            specifications.add((r, q, c) ->
                    c.equal(r.get("dataBlocco"),  query.getDataBlocco()));
        }
        if (query.getDataSblocco() != null) {
            specifications.add((r, q, c) ->
                    c.equal(r.get("dataSblocco"),  query.getDataSblocco()));
        }
        if (query.getDataRiconsegna() != null) {
            specifications.add((r, q, c) ->
                    c.equal(r.get("dataRiconsegna"),  query.getDataRiconsegna()));
        }
        if (query.getCausale() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("causale")), "%" + query.getCausale().toUpperCase() + "%"));
        }
        if (query.getStato() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("stato")), "%" + query.getStato().toUpperCase() + "%"));
        }
        if (query.getVersion() != null) {
            specifications.add((r, q, c) ->
                    c.equal(r.get("version"),  query.getVersion()));
        }
        Specification<SostituzioniBadgeQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);
        Page<SostituzioniBadgeQueryEntity> page = this.sostituzioniBadgeRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public SostituzioniBadgeResponse searchSostituzioniBadge(SostituzioniBadgeSearchRequest query) {

        SostituzioniBadgeResponse sostituzioniBadgeResponse = new SostituzioniBadgeResponse();
        Page<SostituzioniBadgeQueryEntity> page = searchQuerySostituzioniBadge(query);
        List<SostituzioniBadgeQueryDTO> list = page.getContent().stream()
                .map(entity -> sostituzioniBadgeQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        sostituzioniBadgeResponse.setRecords(list);

        sostituzioniBadgeResponse.setPagination(Pagination.buildPagination(page));

        return sostituzioniBadgeResponse;
    }

}
