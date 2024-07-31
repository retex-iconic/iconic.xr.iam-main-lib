package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.RoutingSectionsQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RoutingSectionsRepository
        extends JpaRepository<RoutingSectionsQueryEntity, String>, JpaSpecificationExecutor<RoutingSectionsQueryEntity> {
    RoutingSectionsQueryEntity findByRoutingIdAndCodice(String routingId, String codice);
    List<RoutingSectionsQueryEntity> findAllByRoutingIdAndCodice(String routingId, String codice);
    List<RoutingSectionsQueryEntity> findAllByRoutingId(String id);
}

