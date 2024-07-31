package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.RuoliNotificheQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RuoliNotificheRepository extends JpaRepository<RuoliNotificheQueryEntity, String>, JpaSpecificationExecutor<RuoliNotificheQueryEntity> {
    RuoliNotificheQueryEntity findByNotificaIdAndRuoloId(String notificaId, String ruoloId);
    List<RuoliNotificheQueryEntity> findAllByNotificaIdAndRuoloId(String notificaId, String ruoloId);
    List<RuoliNotificheQueryEntity> findAllByRuoloId(String id);
}

