package com.retexspa.xr.ms.iam.main.query.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.retexspa.xr.ms.iam.main.core.entities.ApplicazioniQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.ApplicazioniFilter;
import com.retexspa.xr.ms.iam.main.core.responses.applicazioni.ApplicazioniResponse;
import com.retexspa.xr.ms.iam.main.query.entities.ApplicazioniQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.ApplicazioniQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.ApplicazioniRepository;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicazioniQueryServiceImpl implements ApplicazioniQueryService {

    @Autowired
    private ApplicazioniRepository applicazioniRepository;

    @Autowired
    private ApplicazioniQueryMapper applicazioniQueryMapper;

    @Override
    public Page<ApplicazioniQueryEntity> searchQueryApplicazioni(GenericSearchRequest<ApplicazioniFilter> query) {
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

        List<Specification<ApplicazioniQueryEntity>> specifications = new ArrayList<>();

        ApplicazioniFilter filter = ApplicazioniFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
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

        if (filter.getSocietaId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("societa").get("id"), filter.getSocietaId()));
        }

        if (filter.getIconicApplicazioniId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("iconicApplicazioni").get("id"), filter.getIconicApplicazioniId()));
        }

       /*  if (filter.getImmagine() != null) {
            specifications.add((r, q, c) -> c.equal(c.length(r.get("immagine")), filter.getImmagine()));
        } */

        if (filter.getFlgRuoloUnico() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgRuoloUnico")), "%" + filter.getFlgRuoloUnico().toUpperCase() + "%"));
        }

        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }
        Specification<ApplicazioniQueryEntity> specification = specifications.stream().reduce(Specification::and)
                .orElse(null);

        Page<ApplicazioniQueryEntity> page = this.applicazioniRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public ApplicazioniResponse searchApplicazioni(GenericSearchRequest<ApplicazioniFilter> query) {

        ApplicazioniResponse applicazioniResponse = new ApplicazioniResponse();
        Page<ApplicazioniQueryEntity> page = searchQueryApplicazioni(query);
        List<ApplicazioniQueryDTO> list = page.getContent().stream()
                // .map(entity -> modelMapper.map(entity, ApplicazioniQueryDTO.class))
                .map(entity -> applicazioniQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        applicazioniResponse.setRecords(list);

        applicazioniResponse.setPagination(Pagination.buildPagination(page));

        return applicazioniResponse;
    }

}
