package com.retexspa.xr.ms.iam.main.query.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.retexspa.xr.ms.iam.main.core.entities.IconicApplicazioniQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.IconicApplicazioniFilter;
import com.retexspa.xr.ms.iam.main.core.responses.iconicApplicazioni.IconicApplicazioniResponse;
import com.retexspa.xr.ms.iam.main.query.entities.IconicApplicazioniQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.IconicApplicazioniQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.IconicApplicazioniRepository;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IconicApplicazioniQueryServiceImpl implements IconicApplicazioniQueryService {

    @Autowired
    private IconicApplicazioniRepository iconicApplicazioniRepository;

    @Autowired
    private IconicApplicazioniQueryMapper iconicApplicazioniQueryMapper;

    @Override
    public Page<IconicApplicazioniQueryEntity> searchQueryIconicApplicazioni(GenericSearchRequest<IconicApplicazioniFilter> query) {
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

        List<Specification<IconicApplicazioniQueryEntity>> specifications = new ArrayList<>();

        IconicApplicazioniFilter filter = IconicApplicazioniFilter.createFilterFromMap(query.getFilter());

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
    
        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }
        Specification<IconicApplicazioniQueryEntity> specification = specifications.stream().reduce(Specification::and)
                .orElse(null);

        Page<IconicApplicazioniQueryEntity> page = this.iconicApplicazioniRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public IconicApplicazioniResponse searchIconicApplicazioni(GenericSearchRequest<IconicApplicazioniFilter> query) {

        IconicApplicazioniResponse iconicApplicazioniResponse = new IconicApplicazioniResponse();
        Page<IconicApplicazioniQueryEntity> page = searchQueryIconicApplicazioni(query);
        List<IconicApplicazioniQueryDTO> list = page.getContent().stream()
                // .map(entity -> modelMapper.map(entity, ApplicazioniQueryDTO.class))
                .map(entity -> iconicApplicazioniQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        iconicApplicazioniResponse.setRecords(list);

        iconicApplicazioniResponse.setPagination(Pagination.buildPagination(page));

        return iconicApplicazioniResponse;
    }

}
