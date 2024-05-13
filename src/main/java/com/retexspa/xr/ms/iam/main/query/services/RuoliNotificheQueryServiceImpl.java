package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.RuoliNotificheQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.RuoliNotificheFilter;
import com.retexspa.xr.ms.iam.main.core.responses.ruoliNotifiche.RuoliNotificheResponse;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliNotificheQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.RuoliNotificheQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.RuoliNotificheRepository;
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
public class RuoliNotificheQueryServiceImpl implements RuoliNotificheQueryService {

    @Autowired
    private RuoliNotificheRepository ruoliNotificheRepository;

    @Autowired
    private RuoliNotificheQueryMapper ruoliNotificheQueryMapper;

    @Override
    public Page<RuoliNotificheQueryEntity> searchQueryRuoliNotifiche(GenericSearchRequest<RuoliNotificheFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {
                switch(baseSort.getOrderBy()){
                    case "id":
                        break;

                    case "notificaId":
                        break;

                    case "ruoloId":
                        break;

                    case "version":
                        break;
                    default:
                        throw new IllegalArgumentException("Order by is not correct");
                }
                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null ?
                                (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC) :
                                Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "notificaId")
                );

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "notificaId"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<RuoliNotificheQueryEntity>> specifications = new ArrayList<>();

        RuoliNotificheFilter filter = RuoliNotificheFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getNotificaId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("notifica").get("id"), filter.getNotificaId()));
        }
        if (filter.getRuoloId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("ruolo").get("id"), filter.getRuoloId()));
        }

        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }
        Specification<RuoliNotificheQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<RuoliNotificheQueryEntity> page = this.ruoliNotificheRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public RuoliNotificheResponse searchRuoliNotifiche(GenericSearchRequest<RuoliNotificheFilter> query) {

        RuoliNotificheResponse ruoliNotificheResponse = new RuoliNotificheResponse();
        Page<RuoliNotificheQueryEntity> page = searchQueryRuoliNotifiche(query);
        List<RuoliNotificheQueryDTO> list = page.getContent().stream()
                .map(entity -> ruoliNotificheQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        ruoliNotificheResponse.setRecords(list);

        ruoliNotificheResponse.setPagination(Pagination.buildPagination(page));

        return ruoliNotificheResponse;
    }
}

