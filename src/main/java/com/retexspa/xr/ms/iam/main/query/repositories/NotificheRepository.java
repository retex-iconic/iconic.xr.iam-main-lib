package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.NotificheQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface NotificheRepository extends JpaRepository<NotificheQueryEntity, String>, JpaSpecificationExecutor<NotificheQueryEntity> {
    NotificheQueryEntity findByRoutingIdAndIconicApplicazioniId(String routingId, String iconicApplicazioniId);
    List<NotificheQueryEntity> findAllByRoutingIdAndIconicApplicazioniId(String routingId, String iconicApplicazioniId);
    List<NotificheQueryEntity> findAllByIconicApplicazioniId(String id);
    List<NotificheQueryEntity> findAllByRoutingId(String id);
}
