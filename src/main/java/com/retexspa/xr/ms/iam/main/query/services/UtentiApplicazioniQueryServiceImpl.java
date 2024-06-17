package com.retexspa.xr.ms.iam.main.query.services;


import com.retexspa.xr.ms.iam.main.core.entities.UtentiApplicazioniQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.UtentiApplicazioniFilter;
import com.retexspa.xr.ms.iam.main.core.responses.utentiApplicazioni.UtentiApplicazioniResponse;
import com.retexspa.xr.ms.iam.main.query.entities.UtentiApplicazioniQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.UtentiApplicazioniQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.UtentiApplicazioniRepository;
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
public class UtentiApplicazioniQueryServiceImpl implements UtentiApplicazioniQueryService {

    @Autowired
    private UtentiApplicazioniRepository utentiApplicazioniRepository;

    @Autowired
    private UtentiApplicazioniQueryMapper utentiApplicazioniQueryMapper;

    @Override
    public Page<UtentiApplicazioniQueryEntity> searchQueryUtentiApplicazioni(
            GenericSearchRequest<UtentiApplicazioniFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();
        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {

                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null
                                ? (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC
                                        : Sort.Direction.DESC)
                                : Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "id"));
                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "id"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        UtentiApplicazioniFilter filter = UtentiApplicazioniFilter.createFilterFromMap(query.getFilter());

        List<Specification<UtentiApplicazioniQueryEntity>> specifications = new ArrayList<>();

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getContestoId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("contesto").get("id"), filter.getContestoId()));
        }
        if (filter.getRuoloId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("ruolo").get("id"), filter.getRuoloId()));
        }
        if (filter.getApplicazioneId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("ruolo").get("applicazioni").get("id"), filter.getApplicazioneId()));
        }
        if (filter.getUtenteId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("utente").get("id"), filter.getUtenteId()));
        }
        if (filter.getIdAccount() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("utente").get("idAccount"), filter.getIdAccount()));
        }
        if (filter.getFlgAcquisizioneAuto() != null) {
            specifications.add((r, q, c) -> c.like(c.upper(r.get("flgAcquisizioneAuto")),
                    "%" + filter.getFlgAcquisizioneAuto().toUpperCase() + "%"));
        }
        if (filter.getDataInizioValidita() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("dataInizioValidita"), filter.getDataInizioValidita()));
        }

        if (filter.getDataFineValidita() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("dataFineValidita"), filter.getDataFineValidita()));
        }

        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }

        Specification<UtentiApplicazioniQueryEntity> specification = specifications.stream().reduce(Specification::and)
                .orElse(null);
        Page<UtentiApplicazioniQueryEntity> page = this.utentiApplicazioniRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public UtentiApplicazioniResponse searchUtentiApplicazioni(GenericSearchRequest<UtentiApplicazioniFilter> query) {

        UtentiApplicazioniResponse utentiApplicazioniResponse = new UtentiApplicazioniResponse();
        Page<UtentiApplicazioniQueryEntity> page = searchQueryUtentiApplicazioni(query);
        List<UtentiApplicazioniQueryDTO> list = page.getContent().stream()
                .map(entity -> utentiApplicazioniQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        utentiApplicazioniResponse.setRecords(list);

        utentiApplicazioniResponse.setPagination(Pagination.buildPagination(page));

        return utentiApplicazioniResponse;
    }

}
