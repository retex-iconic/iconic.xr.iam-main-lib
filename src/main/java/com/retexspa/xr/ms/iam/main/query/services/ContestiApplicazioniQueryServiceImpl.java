package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.ContestiApplicazioniQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.ContestiApplicazioniFilter;
import com.retexspa.xr.ms.iam.main.core.responses.contestiApplicazioni.ContestiApplicazioniResponse;
import com.retexspa.xr.ms.iam.main.query.entities.ContestiApplicazioniQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.ContestiApplicazioniQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.ContestiApplicazioniRepository;
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
public class ContestiApplicazioniQueryServiceImpl implements ContestiApplicazioniQueryService {
    @Autowired
    private ContestiApplicazioniRepository contestiApplicazioniRepository;

    @Autowired
    private ContestiApplicazioniQueryMapper contestiApplicazioniQueryMapper;

    @Override
    public Page<ContestiApplicazioniQueryEntity> searchQueryContestiApplicazioni(
            GenericSearchRequest<ContestiApplicazioniFilter> query) {
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

        List<Specification<ContestiApplicazioniQueryEntity>> specifications = new ArrayList<>();

        ContestiApplicazioniFilter filter = ContestiApplicazioniFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getCodice() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
        }

        if (filter.getDescrizione() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
        }

        if (filter.getNome() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
        }

        if (filter.getFlgAcquisizioneAuto() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgAcquisizioneAuto")),
                            "%" + filter.getFlgAcquisizioneAuto().toUpperCase() + "%"));
        }

        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }

        if (filter.getTipoContestoApplicazioneId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("tipoContestoApplicazione").get("id"),
                    filter.getTipoContestoApplicazioneId()));
        }

        if (filter.getApplicazioneId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("tipoContestoApplicazione")
                    .get("applicazione").get("id"),
                    filter.getApplicazioneId()));
        }

        Specification<ContestiApplicazioniQueryEntity> specification = specifications.stream()
                .reduce(Specification::and).orElse(null);

        Page<ContestiApplicazioniQueryEntity> page = this.contestiApplicazioniRepository.findAll(specification,
                pageable);
        return page;
    }

    @Override
    public ContestiApplicazioniResponse searchContestiApplicazioni(
            GenericSearchRequest<ContestiApplicazioniFilter> query) {

        ContestiApplicazioniResponse contestiApplicazioniResponse = new ContestiApplicazioniResponse();
        Page<ContestiApplicazioniQueryEntity> page = searchQueryContestiApplicazioni(query);
        List<ContestiApplicazioniQueryDTO> list = page.getContent().stream()
                .map(entity -> contestiApplicazioniQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        contestiApplicazioniResponse.setRecords(list);

        contestiApplicazioniResponse.setPagination(Pagination.buildPagination(page));

        return contestiApplicazioniResponse;
    }

}
