package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.AnagAttributiRuoliQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.AnagAttributiRuoliFilter;
import com.retexspa.xr.ms.iam.main.core.responses.anagAttributiRuoli.AnagAttributiRuoliResponse;
import com.retexspa.xr.ms.iam.main.query.entities.AnagAttributiRuoliQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.AnagAttributiRuoliQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.AnagAttributiRuoliRepository;
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
public class AnagAttributiRuoliQueryServiceImpl implements AnagAttributiRuoliQueryService {

    @Autowired
    private AnagAttributiRuoliRepository anagAttributiRuoliRepository;

    @Autowired
    private AnagAttributiRuoliQueryMapper anagAttributiRuoliQueryMapper;

    @Override
    public Page<AnagAttributiRuoliQueryEntity> searchQueryAnagAttributiRuoli(GenericSearchRequest<AnagAttributiRuoliFilter> query) {
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

        List<Specification<AnagAttributiRuoliQueryEntity>> specifications = new ArrayList<>();

        AnagAttributiRuoliFilter filter = AnagAttributiRuoliFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getApplicazioneId() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("applicazione").get("id")), "%" + filter.getApplicazioneId().toUpperCase() + "%"));
        }
        if (filter.getShareApplicazioneId() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("shareApplicazione").get("id")), "%" + filter.getShareApplicazioneId().toUpperCase() + "%"));
        }
        if (filter.getNomeAttributo() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("nomeAttributo")), "%" + filter.getNomeAttributo().toUpperCase() + "%"));
        }
        if (filter.getTipo() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("tipo")), "%" + filter.getTipo().toUpperCase() + "%"));
        }
        if (filter.getFormato() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("formato")), "%" + filter.getFormato().toUpperCase() + "%"));
        }
        if (filter.getPosizione() != null) {
            specifications.add((r, q, c) ->
                    c.equal(r.get("posizione"), filter.getPosizione()));
        }
        if (filter.getFlgCifrato() != null) {
            specifications.add((r, q, c) ->
                    c.equal(r.get("flgCifrato"), filter.getFlgCifrato()));
        }
        if (filter.getFlgUnico() != null) {
            specifications.add((r, q, c) ->
                    c.equal(r.get("flgUnico"), filter.getFlgUnico()));
        }
        if (filter.getFlgObbligatorio() != null) {
            specifications.add((r, q, c) ->
                    c.equal(r.get("flgObbligatorio"), filter.getFlgObbligatorio()));
        }
        if (filter.getDefaultValue() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("defaultValue")), "%" + filter.getDefaultValue().toUpperCase() + "%"));
        }
        if (filter.getCheckFunction() != null) {
            specifications.add((r, q, c) ->
                    c.like(c.upper(r.get("checkFunction")), "%" + filter.getCheckFunction().toUpperCase() + "%"));
        }

        Specification<AnagAttributiRuoliQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);
        Page<AnagAttributiRuoliQueryEntity> page = this.anagAttributiRuoliRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public AnagAttributiRuoliResponse searchAnagAttributiRuoli(GenericSearchRequest<AnagAttributiRuoliFilter> query) {

        AnagAttributiRuoliResponse anagAttributiRuoliResponse = new AnagAttributiRuoliResponse();
        Page<AnagAttributiRuoliQueryEntity> page = searchQueryAnagAttributiRuoli(query);
        List<AnagAttributiRuoliQueryDTO> list = page.getContent().stream()
                .map(entity -> anagAttributiRuoliQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        anagAttributiRuoliResponse.setRecords(list);

        anagAttributiRuoliResponse.setPagination(Pagination.buildPagination(page));

        return anagAttributiRuoliResponse;
    }  
   
}
