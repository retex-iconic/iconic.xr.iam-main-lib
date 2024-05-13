package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.AnagAttributiUtentiQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.AnagAttributiUtentiFilter;
import com.retexspa.xr.ms.iam.main.core.responses.anagAttributiUtenti.AnagAttributiUtentiResponse;
import com.retexspa.xr.ms.iam.main.query.entities.AnagAttributiUtentiQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.AnagAttributiUtentiQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.AnagAttributiUtentiRepository;
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
public class AnagAttributiUtentiQueryServiceImpl implements AnagAttributiUtentiQueryService {

    @Autowired
    private AnagAttributiUtentiRepository anagAttributiUtentiRepository;

    @Autowired
    private AnagAttributiUtentiQueryMapper anagAttributiUtentiQueryMapper;

    @Override
    public Page<AnagAttributiUtentiQueryEntity> searchQueryAnagAttributiUtenti(GenericSearchRequest<AnagAttributiUtentiFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {

                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null ?
                                (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC) :
                                Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "nomeAttributo")
                );

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "nomeAttributo"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<AnagAttributiUtentiQueryEntity>> specifications = new ArrayList<>();

        AnagAttributiUtentiFilter filter = AnagAttributiUtentiFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getNomeAttributo() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("nomeAttributo")), "%" + filter.getNomeAttributo().toUpperCase() + "%"));
        }

        if (filter.getPosizione() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("posizione"), filter.getPosizione()));
        }

        if (filter.getTipo() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("tipo")), "%" + filter.getTipo().toUpperCase() + "%"));
        }

        if (filter.getFormato() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("formato")), "%" + filter.getFormato().toUpperCase() + "%"));
        }

        if (filter.getFlgCifrato() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgCifrato")), "%" + filter.getFlgCifrato().toUpperCase() + "%"));
        }

        if (filter.getFlgUnico() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgUnico")), "%" + filter.getFlgUnico().toUpperCase() + "%"));
        }

        if (filter.getFlgObbligatorio() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgObbligatorio")), "%" + filter.getFlgObbligatorio().toUpperCase() + "%"));
        }

        if (filter.getDefaultValue() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("defaultValue")), "%" + filter.getDefaultValue().toUpperCase() + "%"));
        }

        if (filter.getCheckFunction() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("checkFunction")), "%" + filter.getCheckFunction().toUpperCase() + "%"));
        }

        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }

        if (filter.getTipoContestoApplicazioneId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("tipoContestoApplicazione").get("id"), filter.getTipoContestoApplicazioneId()));
        }

        if (filter.getShareTipoContestoApplicazioneId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("shareTipoContestoApplicazione").get("id"), filter.getShareTipoContestoApplicazioneId()));
        }

        Specification<AnagAttributiUtentiQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<AnagAttributiUtentiQueryEntity> page = this.anagAttributiUtentiRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public AnagAttributiUtentiResponse searchAnagAttributiUtenti(GenericSearchRequest<AnagAttributiUtentiFilter> query) {

        AnagAttributiUtentiResponse anagAttributiUtentiResponse = new AnagAttributiUtentiResponse();
        Page<AnagAttributiUtentiQueryEntity> page = searchQueryAnagAttributiUtenti(query);
        List<AnagAttributiUtentiQueryDTO> list = page.getContent().stream()
                .map(entity -> anagAttributiUtentiQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        anagAttributiUtentiResponse.setRecords(list);

        anagAttributiUtentiResponse.setPagination(Pagination.buildPagination(page));

        return anagAttributiUtentiResponse;
    }

}
