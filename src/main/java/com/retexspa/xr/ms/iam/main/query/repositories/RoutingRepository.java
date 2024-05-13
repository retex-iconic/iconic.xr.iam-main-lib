package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.RoutingQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RoutingRepository
        extends JpaRepository<RoutingQueryEntity, String>, JpaSpecificationExecutor<RoutingQueryEntity> {
    RoutingQueryEntity findByRoutingCharIdAndApplicazioneId(String routingCharId, String applicazioneId);
    List<RoutingQueryEntity> findAllByRoutingCharIdAndApplicazioneId(String routingCharId, String applicazioneId);
}
