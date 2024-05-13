package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.RuoliApplicazioneQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RuoliApplicazioneRepository extends JpaRepository<RuoliApplicazioneQueryEntity, String>, JpaSpecificationExecutor<RuoliApplicazioneQueryEntity> {
    RuoliApplicazioneQueryEntity findByCodiceAndApplicazioniId(String codice, String applicazioniId);
    List<RuoliApplicazioneQueryEntity> findAllByCodiceAndApplicazioniId(String codice, String applicazioniId);
}
