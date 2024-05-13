package com.retexspa.xr.ms.iam.main.query.services;


import com.retexspa.xr.ms.iam.main.core.entities.SocietaQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.SocietaFilter;
import com.retexspa.xr.ms.iam.main.core.responses.societa.SocietaResponse;
import com.retexspa.xr.ms.iam.main.query.entities.SocietaQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.SocietaQueryMapper;
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

import com.retexspa.xr.ms.iam.main.query.repositories.SocietaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class SocietaQueryServiceImpl implements SocietaQueryService {

    @Autowired
    private SocietaRepository societaRepository;

    @Autowired
    private SocietaQueryMapper societaQueryMapper;

    @Override
    public Page<SocietaQueryEntity> searchQuerySocieta(GenericSearchRequest<SocietaFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {

                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null ?
                                (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC) :
                                Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "codice")
                );

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "codice"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<SocietaQueryEntity>> specifications = new ArrayList<>();

        SocietaFilter filter = SocietaFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getCodice() != null) {
            specifications.add((r, q, c) -> c.like(
                    c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
        }

        if (filter.getGerarchiaId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("gerarchia").get("id"), filter.getGerarchiaId()));
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
        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }
        Specification<SocietaQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<SocietaQueryEntity> page = this.societaRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public SocietaResponse searchSocieta(GenericSearchRequest<SocietaFilter> query) {

        SocietaResponse SocietaResponse = new SocietaResponse();
        Page<SocietaQueryEntity> page = searchQuerySocieta(query);
        List<SocietaQueryDTO> list = page.getContent().stream()
                // .map(entity -> modelMapper.map(entity, SocietaQueryDTO.class))
                .map(entity -> societaQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        SocietaResponse.setRecords(list);

        SocietaResponse.setPagination(Pagination.buildPagination(page));

        return SocietaResponse;
    }  
   
}
