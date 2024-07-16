package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.iam.main.core.entities.SostituzioniBadgeQueryDTO;
import com.retexspa.xr.ms.iam.main.core.filterRequest.SostituzioniBadgeFilter;
import com.retexspa.xr.ms.iam.main.core.responses.sostituzioniBadge.SostituzioniBadgeResponse;
import com.retexspa.xr.ms.iam.main.query.entities.BadgeSocietaQueryEntity;
import com.retexspa.xr.ms.iam.main.query.entities.SostituzioniBadgeQueryEntity;
import com.retexspa.xr.ms.iam.main.query.mappers.SostituzioniBadgeQueryMapper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.retexspa.xr.ms.iam.main.query.entities.UtentiSocietaQueryEntity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class SostituzioniBadgeQueryServiceImpl implements SostituzioniBadgeQueryService {
    @Autowired
    private SostituzioniBadgeQueryMapper sostituzioniBadgeQueryMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<SostituzioniBadgeQueryEntity> searchQuerySostituzioniBadge(
            GenericSearchRequest<SostituzioniBadgeFilter> query) {
        List<Sort.Order> sorts = new ArrayList<>();
        if (query.getSort() != null && !query.getSort().isEmpty()) {
            for (BaseSort baseSort : query.getSort()) {
                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null
                                ? (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC
                                        : Sort.Direction.DESC)
                                : Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "id"));
                sorts.add(sort);
            }
        }
        if (sorts.isEmpty()) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "id"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<SostituzioniBadgeQueryEntity> cq = cb.createQuery(SostituzioniBadgeQueryEntity.class);
        Root<SostituzioniBadgeQueryEntity> root = cq.from(SostituzioniBadgeQueryEntity.class);

        Join<SostituzioniBadgeQueryEntity, UtentiSocietaQueryEntity> utentiJoin = root.join("utenti", JoinType.LEFT);
        Join<SostituzioniBadgeQueryEntity, BadgeSocietaQueryEntity> badgeJoin = root.join("badge", JoinType.LEFT);

        List<javax.persistence.criteria.Order> orders = new ArrayList<>();
        for (Sort.Order sortOrder : sorts) {
            Path<?> path;
            if ("utentiId".equals(sortOrder.getProperty())) {
                path = utentiJoin.get("id");
            } else if ("badgeId".equals(sortOrder.getProperty())) {
                path = badgeJoin.get("id");
            } else if ("tipoBadge".equals(sortOrder.getProperty())) {
                path = badgeJoin.get("tipoBadge");
            } else if ("codiceBadge".equals(sortOrder.getProperty())) {
                path = badgeJoin.get("codiceBadge");
            } else {
                path = root.get(sortOrder.getProperty());
            }

            if (sortOrder.isAscending()) {
                orders.add(cb.asc(path));
            } else {
                orders.add(cb.desc(path));
            }
        }
        cq.orderBy(orders);

        List<Specification<SostituzioniBadgeQueryEntity>> specifications = new ArrayList<>();

        SostituzioniBadgeFilter filter = SostituzioniBadgeFilter.createFilterFromMap(query.getFilter());

        Expression<Timestamp> currentTimestamp = cb.currentTimestamp();

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }
        if (filter.getUtentiId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("utenti").get("id"), filter.getUtentiId()));
        }
        if (filter.getBadgeId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("badge").get("id"), filter.getBadgeId()));
        }
        if (filter.getTipoBadge() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("badge").get("tipoBadge"), filter.getTipoBadge()));
        }
        if (filter.getCodiceBadge() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("badge").get("codiceBadge")),
                            "%" + filter.getCodiceBadge().toUpperCase() + "%"));
        }
        if (filter.getDataAssegnazione() != null) {
            specifications.add((r, q, c) -> c.equal(
                    c.function("DATE", Date.class, r.get("dataAssegnazione")),
                    filter.getDataAssegnazione()));
        }
        if (filter.getDataBlocco() != null) {
            specifications.add((r, q, c) -> c.equal(
                    c.function("DATE", Date.class, r.get("dataBlocco")),
                    filter.getDataBlocco()));
        }
        if (filter.getDataSblocco() != null) {
            specifications.add((r, q, c) -> c.equal(
                    c.function("DATE", Date.class, r.get("dataSblocco")),
                    filter.getDataSblocco()));
        }
        if (filter.getDataRiconsegna() != null) {
            specifications.add((r, q, c) -> c.equal(
                    c.function("DATE", Date.class, r.get("dataRiconsegna")),
                    filter.getDataRiconsegna()));
        }
        if (filter.getCausale() != null) {
            specifications
                    .add((r, q, c) -> c.like(c.upper(r.get("causale")), "%" + filter.getCausale().toUpperCase() + "%"));
        }
        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }
        if (filter.getStato() != null) {
            if (filter.getStato().equals(Enums.StatoBadgeSostitutivo.R.toString())) {
                // dataRiconsegna != null && this.today > dataRiconsegna

                Specification<SostituzioniBadgeQueryEntity> spec1 = (r, q, c) -> c.isNotNull(r.get("dataRiconsegna"));
                Specification<SostituzioniBadgeQueryEntity> spec2 = (r, q, c) -> c.greaterThan(currentTimestamp,
                        r.get("dataRiconsegna"));

                Specification<SostituzioniBadgeQueryEntity> combinedSpec = spec1.and(spec2);

                specifications.add(combinedSpec);

            } else if (filter.getStato().equals(Enums.StatoBadgeSostitutivo.B.toString())) {
                // (dataRiconsegna! > this.today! || dataRiconsegna == null) &&
                // (dataBlocco != null) &&
                // (dataBlocco < this.today)

                Specification<SostituzioniBadgeQueryEntity> spec1 = (r, q, c) -> c.greaterThan(r.get("dataRiconsegna"),
                        currentTimestamp);
                Specification<SostituzioniBadgeQueryEntity> spec2 = (r, q, c) -> c.isNull(r.get("dataRiconsegna"));

                Specification<SostituzioniBadgeQueryEntity> combinedSpec1 = spec1.or(spec2);

                Specification<SostituzioniBadgeQueryEntity> spec3 = (r, q, c) -> c.isNotNull(r.get("dataBlocco"));
                Specification<SostituzioniBadgeQueryEntity> spec4 = (r, q, c) -> c.lessThan(r.get("dataBlocco"),
                        currentTimestamp);

                Specification<SostituzioniBadgeQueryEntity> combinedSpec2 = spec3.and(spec4);

                Specification<SostituzioniBadgeQueryEntity> combinedSpecFinal = combinedSpec1.and(combinedSpec2);


            } else if (filter.getStato().equals(Enums.StatoBadgeSostitutivo.A.toString())) {
                // (dataBlocco == null || dataBlocco > this.today) &&
                // (dataRiconsegna == null || dataRiconsegna > this.today) &&
                // (dataAssegnazione != null && dataAssegnazione < this.today)

                Specification<SostituzioniBadgeQueryEntity> spec1 = (r, q, c) -> c.isNull(r.get("dataBlocco"));
                Specification<SostituzioniBadgeQueryEntity> spec2 = (r, q, c) -> c.greaterThan(r.get("dataBlocco"),
                        currentTimestamp);

                Specification<SostituzioniBadgeQueryEntity> combinedSpec1 = spec1.or(spec2);

                Specification<SostituzioniBadgeQueryEntity> spec3 = (r, q, c) -> c.isNull(r.get("dataRiconsegna"));
                Specification<SostituzioniBadgeQueryEntity> spec4 = (r, q, c) -> c.greaterThan(r.get("dataRiconsegna"),
                        currentTimestamp);

                Specification<SostituzioniBadgeQueryEntity> combinedSpec2 = spec3.or(spec4);

                Specification<SostituzioniBadgeQueryEntity> spec5 = (r, q, c) -> c.isNotNull(r.get("dataAssegnazione"));
                Specification<SostituzioniBadgeQueryEntity> spec6 = (r, q, c) -> c.lessThan(r.get("dataAssegnazione"),
                        currentTimestamp);

                Specification<SostituzioniBadgeQueryEntity> combinedSpec3 = spec5.and(spec6);

                Specification<SostituzioniBadgeQueryEntity> combinedSpecFinal = combinedSpec1.and(combinedSpec2)
                        .and(combinedSpec3);

                specifications.add(combinedSpecFinal);

            }
        }

        Specification<SostituzioniBadgeQueryEntity> specification = specifications.stream().reduce(Specification::and)
                .orElse(null);

        if (specification != null) {
            cq.where(specification.toPredicate(root, cq, cb));
        }

        TypedQuery<SostituzioniBadgeQueryEntity> queryResult = entityManager.createQuery(cq);
        queryResult.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        queryResult.setMaxResults(pageable.getPageSize());

        List<SostituzioniBadgeQueryEntity> resultList = queryResult.getResultList();
        long total = getTotalCount(specification, entityManager); // Implement a method to get total count

        return new PageImpl<>(resultList, pageable, total);
    }

    private long getTotalCount(Specification<SostituzioniBadgeQueryEntity> specification, EntityManager entityManager) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<SostituzioniBadgeQueryEntity> countRoot = countQuery.from(SostituzioniBadgeQueryEntity.class);

        countQuery.select(cb.count(countRoot));

        if (specification != null) {
            countQuery.where(specification.toPredicate(countRoot, countQuery, cb));
        }

        return entityManager.createQuery(countQuery).getSingleResult();
    }

    @Override
    public SostituzioniBadgeResponse searchSostituzioniBadge(GenericSearchRequest<SostituzioniBadgeFilter> query) {

        SostituzioniBadgeResponse sostituzioniBadgeResponse = new SostituzioniBadgeResponse();
        Page<SostituzioniBadgeQueryEntity> page = searchQuerySostituzioniBadge(query);
        List<SostituzioniBadgeQueryDTO> list = page.getContent().stream()
                .map(entity -> sostituzioniBadgeQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        sostituzioniBadgeResponse.setRecords(list);

        sostituzioniBadgeResponse.setPagination(Pagination.buildPagination(page));

        return sostituzioniBadgeResponse;
    }

}
