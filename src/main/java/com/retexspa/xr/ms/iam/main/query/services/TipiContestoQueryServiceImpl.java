package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.TipiContestoQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.TipiContestoFilter;
import com.retexspa.xr.ms.iam.main.core.responses.tipiContesto.TipiContestoResponse;
import com.retexspa.xr.ms.iam.main.query.entities.TipiContestoQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.TipiContestoQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.TipiContestoRepository;
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
public class TipiContestoQueryServiceImpl implements TipiContestoQueryService {

    @Autowired
    private TipiContestoRepository tipiContestoRepository;

    @Autowired
    private TipiContestoQueryMapper tipiContestoQueryMapper;

    @Override
    public Page<TipiContestoQueryEntity> searchQueryTipiContesto(GenericSearchRequest<TipiContestoFilter> query) {
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

        List<Specification<TipiContestoQueryEntity>> specifications = new ArrayList<>();
        TipiContestoFilter filter = TipiContestoFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getCodice() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("codice"), filter.getCodice()));
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

        if (filter.getFlgGerarchia() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgGerarchia")), "%" + filter.getFlgGerarchia().toUpperCase() + "%"));
        }
        Specification<TipiContestoQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<TipiContestoQueryEntity> page = this.tipiContestoRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public TipiContestoResponse searchTipiContesto(GenericSearchRequest<TipiContestoFilter> query) {

        TipiContestoResponse tipiContestoResponse = new TipiContestoResponse();
        Page<TipiContestoQueryEntity> page = searchQueryTipiContesto(query);
        List<TipiContestoQueryDTO> list = page.getContent().stream()
                // .map(entity -> modelMapper.map(entity, TipiContestoQueryDTO.class))
                .map(entity -> tipiContestoQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        tipiContestoResponse.setRecords(list);

        tipiContestoResponse.setPagination(Pagination.buildPagination(page));

        return tipiContestoResponse;
    }

}
