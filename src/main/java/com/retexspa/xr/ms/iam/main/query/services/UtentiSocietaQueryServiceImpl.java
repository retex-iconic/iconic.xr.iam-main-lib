package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.UtentiSocietaQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.UtentiSocietaFilter;
import com.retexspa.xr.ms.iam.main.core.responses.utentiSocieta.UtentiSocietaResponse;
import com.retexspa.xr.ms.iam.main.query.entities.UtentiSocietaQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.UtentiSocietaQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.UtentiSocietaRepository;
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
public class UtentiSocietaQueryServiceImpl implements UtentiSocietaQueryService {

    @Autowired
    private UtentiSocietaRepository utentiSocietaRepository;

    @Autowired
    private UtentiSocietaQueryMapper utentiSocietaQueryMapper;

    @Override
    public Page<UtentiSocietaQueryEntity> searchQueryUtentiSocieta(GenericSearchRequest<UtentiSocietaFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {

                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null ?
                                (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC) :
                                Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "idAccount")
                );

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "idAccount"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<UtentiSocietaQueryEntity>> specifications = new ArrayList<>();

        UtentiSocietaFilter filter = UtentiSocietaFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getIdAccount() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("idAccount"), filter.getIdAccount()));
        }

        if (filter.getSocietaId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("societa").get("id"), filter.getSocietaId()));
        }

        if (filter.getDataInizioValidita() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("dataInizioValidita"), filter.getDataInizioValidita()));
        }

        if (filter.getDataFineValidita() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("dataFineValidita"), filter.getDataFineValidita()));
        }

        if (filter.getNome() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
        }

        if (filter.getCognome() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("cognome")), "%" + filter.getCognome().toUpperCase() + "%"));
        }

        if (filter.getMatricola() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("matricola")), "%" + filter.getMatricola().toUpperCase() + "%"));
        }

        if (filter.getCodiceFiscale() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("codiceFiscale")), "%" + filter.getCodiceFiscale().toUpperCase() + "%"));
        }
        
        if (filter.getBadgeId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("badge").get("id"), filter.getBadgeId()));
        }

        if (filter.getStatoBadge() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("statoBadge")), "%" + filter.getStatoBadge().toUpperCase() + "%"));
        }

        if (filter.getIndirrizoEmail() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("indirrizoEmail")), "%" + filter.getIndirrizoEmail().toUpperCase() + "%"));
        }

        if (filter.getUpn() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("upn")), "%" + filter.getUpn().toUpperCase() + "%"));
        }

        if (filter.getPwd() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("pwd")), "%" + filter.getPwd().toUpperCase() + "%"));
        }

        if (filter.getVersion() != null) {
            specifications.add(
                    (r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }

        Specification<UtentiSocietaQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<UtentiSocietaQueryEntity> page = this.utentiSocietaRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public UtentiSocietaResponse searchUtentiSocieta(GenericSearchRequest<UtentiSocietaFilter> query) {

        UtentiSocietaResponse utentiSocietaResponse = new UtentiSocietaResponse();
        Page<UtentiSocietaQueryEntity> page = searchQueryUtentiSocieta(query);
        List<UtentiSocietaQueryDTO> list = page.getContent().stream()
                .map(entity -> utentiSocietaQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        utentiSocietaResponse.setRecords(list);

        utentiSocietaResponse.setPagination(Pagination.buildPagination(page));

        return utentiSocietaResponse;
    }

}
