package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.entities.MenuQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.MenuFilter;
import com.retexspa.xr.ms.iam.main.core.responses.menu.MenuResponse;
import com.retexspa.xr.ms.iam.main.query.entities.MenuQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.MenuQueryMapper;
import com.retexspa.xr.ms.iam.main.query.repositories.MenuRepository;
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
public class MenuQueryServiceImpl implements MenuQueryService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuQueryMapper menuQueryMapper;

    @Override
    public Page<MenuQueryEntity> searchQueryMenu(GenericSearchRequest<MenuFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {
                switch (baseSort.getOrderBy()) {
                    case "id":
                        break;

                    case "menuCharId":
                        break;

                    case "routingId":
                        break;

                    case "ordinamento":
                        break;

                    case "icone":
                        break;

                    case "titolo":
                        break;

                    case "flgAttiva":
                        break;
                    case "homePagina":
                        break;

                    case "tipoMenu":
                        break;

                    case "idMenu":
                        break;

                    case "pidMenu":
                        break;
                    case "queryParams":
                        break;

                    case "nodoId":
                        break;

                    case "version":
                        break;
                    default:
                        throw new IllegalArgumentException("Order by is not correct");
                }
                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null
                                ? (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC
                                        : Sort.Direction.DESC)
                                : Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "menuCharId"));

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "menuCharId"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<MenuQueryEntity>> specifications = new ArrayList<>();
        MenuFilter filter = MenuFilter.createFilterFromMap(query.getFilter());
        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getIdMenu() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("idMenu"), filter.getIdMenu()));
        }

        if (filter.getPidMenu() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("pidMenu"), filter.getPidMenu()));
        }

        if (filter.getMenuCharId() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("menuCharId")), "%" + filter.getMenuCharId().toUpperCase() + "%"));
        }
        if (filter.getRoutingId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("routing").get("id"), filter.getRoutingId()));
        }
        if (filter.getOrdinamento() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("ordinamento"), filter.getOrdinamento()));
        }
        if (filter.getIcone() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("icone")), "%" + filter.getIcone().toUpperCase() + "%"));
        }
        if (filter.getTitolo() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("titolo")), "%" + filter.getTitolo().toUpperCase() + "%"));
        }
        if (filter.getFlgAttiva() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("flgAttiva")), "%" + filter.getFlgAttiva().toUpperCase() + "%"));
        }
        if (filter.getHomePagina() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("homePagina")), "%" + filter.getHomePagina().toUpperCase() + "%"));
        }
        if (filter.getTipoMenu() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("tipoMenu")), "%" + filter.getTipoMenu().toUpperCase() + "%"));
        }
        if (filter.getQueryParams() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("queryParams")), "%" + filter.getQueryParams().toUpperCase() + "%"));
        }
        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }
        if (filter.getNodoId() != null) {
            specifications.add(
                    (r, q, c) -> c.equal(r.get("nodo").get("id"), filter.getNodoId()));
        }
        Specification<MenuQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<MenuQueryEntity> page = this.menuRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public MenuResponse searchMenu(GenericSearchRequest<MenuFilter> query) {

        MenuResponse menuResponse = new MenuResponse();
        Page<MenuQueryEntity> page = searchQueryMenu(query);
        List<MenuQueryDTO> list = page.getContent().stream()
                .map(entity -> menuQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        menuResponse.setRecords(list);

        menuResponse.setPagination(Pagination.buildPagination(page));

        return menuResponse;
    }
}
