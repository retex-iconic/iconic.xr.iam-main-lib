package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.TipiContestoApplicazioneQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.TipiContestoApplicazioneFilter;
import com.retexspa.xr.ms.iam.main.core.responses.tipiContestoApplicazione.TipiContestoApplicazioneResponse;
import com.retexspa.xr.ms.iam.main.query.entities.TipiContestoApplicazioneQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.TipiContestoApplicazioneQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.TipiContestoApplicazioneRepository;
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
public class TipiContestoApplicazioneQueryServiceImpl implements TipiContestoApplicazioneQueryService {

    @Autowired
    private TipiContestoApplicazioneRepository tipiContestoApplicazioneRepository;

    @Autowired
    private TipiContestoApplicazioneQueryMapper tipiContestoApplicazioneQueryMapper;

    @Override
    public Page<TipiContestoApplicazioneQueryEntity> searchQueryTipiContestoApplicazione(GenericSearchRequest<TipiContestoApplicazioneFilter> query) {
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

        List<Specification<TipiContestoApplicazioneQueryEntity>> specifications = new ArrayList<>();
        TipiContestoApplicazioneFilter filter = TipiContestoApplicazioneFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getApplicazioneId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("applicazione").get("id"), filter.getApplicazioneId()));
        }

        if (filter.getTipiContestoId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("tipiContesto").get("id"), filter.getTipiContestoId()));
        }

        if (filter.getTassonomiaId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("tassonomiaId"), filter.getTassonomiaId()));
        }

        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }

        Specification<TipiContestoApplicazioneQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<TipiContestoApplicazioneQueryEntity> page = this.tipiContestoApplicazioneRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public TipiContestoApplicazioneResponse searchTipiContestoApplicazione(GenericSearchRequest<TipiContestoApplicazioneFilter> query) {

        TipiContestoApplicazioneResponse tipiContestoApplicazioneResponse = new TipiContestoApplicazioneResponse();
        Page<TipiContestoApplicazioneQueryEntity> page = searchQueryTipiContestoApplicazione(query);
        List<TipiContestoApplicazioneQueryDTO> list = page.getContent().stream()
                // .map(entity -> modelMapper.map(entity, TipiContestoApplicazioneQueryDTO.class))
                .map(entity -> tipiContestoApplicazioneQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        tipiContestoApplicazioneResponse.setRecords(list);

        tipiContestoApplicazioneResponse.setPagination(Pagination.buildPagination(page));

        return tipiContestoApplicazioneResponse;
    }

}
