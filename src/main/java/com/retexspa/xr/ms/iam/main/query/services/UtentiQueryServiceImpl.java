package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.UtentiQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.UtentiFilter;
import com.retexspa.xr.ms.iam.main.core.responses.utenti.UtentiResponse;
import com.retexspa.xr.ms.iam.main.query.entities.UtentiQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.UtentiQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.UtentiRepository;
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
public class UtentiQueryServiceImpl implements UtentiQueryService {

    @Autowired
    private UtentiRepository utentiRepository;

    @Autowired
    private UtentiQueryMapper utentiQueryMapper;

    @Override
    public Page<UtentiQueryEntity> searchQueryUtenti(GenericSearchRequest<UtentiFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {

                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null
                                ? (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC
                                        : Sort.Direction.DESC)
                                : Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "idAccount"));

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "idAccount"));
        }

        Pageable pageable = PageRequest.of(
                (query.getPage() == null ? 0 : query.getPage()),
                (query.getLimit() == null ? Integer.MAX_VALUE : query.getLimit()),
                Sort.by(sorts));

        List<Specification<UtentiQueryEntity>> specifications = new ArrayList<>();

        UtentiFilter filter = UtentiFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getIdAccount() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("idAccount"), filter.getIdAccount()));
        }

        if (filter.getNome() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
        }

        if (filter.getCognome() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("cognome")), "%" + filter.getCognome().toUpperCase() + "%"));
        }

        if (filter.getCodiceFiscale() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("codiceFiscale")), "%" + filter.getCodiceFiscale().toUpperCase() + "%"));
        }

        if (filter.getVersion() != null) {
            specifications.add(
                    (r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }

        Specification<UtentiQueryEntity> specification = specifications.stream().reduce(Specification::and)
                .orElse(null);

        Page<UtentiQueryEntity> page = this.utentiRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public UtentiResponse searchUtenti(GenericSearchRequest<UtentiFilter> query) {

        UtentiResponse utentiResponse = new UtentiResponse();
        Page<UtentiQueryEntity> page = searchQueryUtenti(query);
        List<UtentiQueryDTO> list = page.getContent().stream()
                .map(entity -> utentiQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        utentiResponse.setRecords(list);

        utentiResponse.setPagination(Pagination.buildPagination(page));

        return utentiResponse;
    }

}
