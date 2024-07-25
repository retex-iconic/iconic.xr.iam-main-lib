package com.retexspa.xr.ms.iam.main.query.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.retexspa.xr.ms.iam.main.query.entities.AnagAttributiRuoliQueryEntity;

public interface AnagAttributiRuoliRepository extends JpaRepository<AnagAttributiRuoliQueryEntity, String>,
        JpaSpecificationExecutor<AnagAttributiRuoliQueryEntity> {

    List<AnagAttributiRuoliQueryEntity> findAllByApplicazioneId(String id);

}
