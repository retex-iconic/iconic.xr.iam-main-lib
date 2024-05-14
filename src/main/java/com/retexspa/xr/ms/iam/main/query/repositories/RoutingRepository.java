package com.retexspa.xr.ms.iam.main.query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.retexspa.xr.ms.iam.main.query.entities.RoutingQueryEntity;

import java.util.List;

public interface RoutingRepository
        extends JpaRepository<RoutingQueryEntity, String>, JpaSpecificationExecutor<RoutingQueryEntity> {
    RoutingQueryEntity findByRoutingCharIdAndIconicApplicazioniId(String routingCharId, String iconicApplicazioniId);
    List<RoutingQueryEntity> findAllByRoutingCharIdAndIconicApplicazioniId(String routingCharId, String applicazioneId);
}
