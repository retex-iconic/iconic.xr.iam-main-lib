package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.NotificheQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.NotificheFilter;
import com.retexspa.xr.ms.iam.main.core.responses.notifiche.NotificheResponse;
import com.retexspa.xr.ms.iam.main.query.entities.NotificheQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.NotificheQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.NotificheRepository;
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
public class NotificheQueryServiceImpl  implements NotificheQueryService {

    @Autowired
    private NotificheRepository notificheRepository;

    @Autowired
    private NotificheQueryMapper notificheQueryMapper;

    @Override
    public Page<NotificheQueryEntity> searchQueryNotifiche(GenericSearchRequest<NotificheFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {
                switch(baseSort.getOrderBy()){
                    case "id":
                        break;

                    case "codice":
                        break;

                    case "titolo":
                        break;

                    case "dettaglio":
                        break;

                    case "icone":
                        break;

                    case "flgAttiva":
                        break;

                    case "routingId":
                        break;

                    case "applicazioneId":
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
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "codice")
                );

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "codice"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<NotificheQueryEntity>> specifications = new ArrayList<>();

        NotificheFilter filter = NotificheFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getCodice() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
        }
        if (filter.getTitolo() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("titolo")), "%" + filter.getTitolo().toUpperCase() + "%"));
        }
        if (filter.getDettaglio() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("dettaglio")), "%" + filter.getDettaglio().toUpperCase() + "%"));
        }
        if (filter.getIcone() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("icone")), "%" + filter.getIcone().toUpperCase() + "%"));
        }
        if (filter.getFlgAttiva() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgAttiva")), "%" + filter.getFlgAttiva().toUpperCase() + "%"));
        }
        if (filter.getRoutingId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("routing").get("id"), filter.getRoutingId()));
        }
        if (filter.getApplicazioneId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("applicazione").get("id"), filter.getApplicazioneId()));
        }

        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }
        Specification<NotificheQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<NotificheQueryEntity> page = this.notificheRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public NotificheResponse searchNotifiche(GenericSearchRequest<NotificheFilter> query) {

        NotificheResponse notificheResponse = new NotificheResponse();
        Page<NotificheQueryEntity> page = searchQueryNotifiche(query);
        List<NotificheQueryDTO> list = page.getContent().stream()
                .map(entity -> notificheQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        notificheResponse.setRecords(list);

        notificheResponse.setPagination(Pagination.buildPagination(page));

        return notificheResponse;
    }
}
