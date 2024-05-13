package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.RuoliApplicazioneQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.RuoliApplicazioneFilter;
import com.retexspa.xr.ms.iam.main.core.responses.ruoliApplicazione.RuoliApplicazioneResponse;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliApplicazioneQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.RuoliApplicazioneQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.RuoliApplicazioneRepository;
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
public class RuoliApplicazioneQueryServiceImpl implements RuoliApplicazioneQueryService {

    @Autowired
    private RuoliApplicazioneRepository ruoliApplicazioneRepository;

    @Autowired
    private RuoliApplicazioneQueryMapper ruoliApplicazioneQueryMapper;

    @Override
    public Page<RuoliApplicazioneQueryEntity> searchQueryRuoliApplicazione(
            GenericSearchRequest<RuoliApplicazioneFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {

                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null
                                ? (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC
                                        : Sort.Direction.DESC)
                                : Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "codice"));

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "codice"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<RuoliApplicazioneQueryEntity>> specifications = new ArrayList<>();

        RuoliApplicazioneFilter filter = RuoliApplicazioneFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getApplicazioniId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("applicazioni").get("id"), filter.getApplicazioniId()));
        }

        if (filter.getCodice() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
        }

        if (filter.getNome() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
        }

        if (filter.getDescrizione() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
        }

        if (filter.getFlgAttivo() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgAttivo")), "%" + filter.getFlgAttivo().toUpperCase() + "%"));
        }

        if (filter.getLivelloIam() != null) {
            specifications.add(
                    (r, q, c) -> c.equal(r.get("livelloIam"), filter.getLivelloIam()));
        }

        if (filter.getVersion() != null) {
            specifications.add(
                    (r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }

        Specification<RuoliApplicazioneQueryEntity> specification = specifications.stream().reduce(Specification::and)
                .orElse(null);

        Page<RuoliApplicazioneQueryEntity> page = this.ruoliApplicazioneRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public RuoliApplicazioneResponse searchRuoliApplicazione(GenericSearchRequest<RuoliApplicazioneFilter> query) {

        RuoliApplicazioneResponse ruoliApplicazioneResponse = new RuoliApplicazioneResponse();
        Page<RuoliApplicazioneQueryEntity> page = searchQueryRuoliApplicazione(query);
        List<RuoliApplicazioneQueryDTO> list = page.getContent().stream()
                .map(entity -> ruoliApplicazioneQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        ruoliApplicazioneResponse.setRecords(list);

        ruoliApplicazioneResponse.setPagination(Pagination.buildPagination(page));

        return ruoliApplicazioneResponse;
    }

}
