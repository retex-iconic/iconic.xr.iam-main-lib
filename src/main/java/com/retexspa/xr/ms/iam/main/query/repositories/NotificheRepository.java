package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.NotificheQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface NotificheRepository extends JpaRepository<NotificheQueryEntity, String>, JpaSpecificationExecutor<NotificheQueryEntity> {
    NotificheQueryEntity findByRoutingIdAndApplicazioneId(String routingId, String aapplicazioneId);
    List<NotificheQueryEntity> findAllByRoutingIdAndApplicazioneId(String routingId, String aapplicazioneId);
}
