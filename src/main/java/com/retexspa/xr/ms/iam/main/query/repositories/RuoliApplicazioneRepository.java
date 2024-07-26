package com.retexspa.xr.ms.iam.main.query.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.retexspa.xr.ms.iam.main.query.entities.RuoliApplicazioneQueryEntity;

public interface RuoliApplicazioneRepository extends JpaRepository<RuoliApplicazioneQueryEntity, String>, JpaSpecificationExecutor<RuoliApplicazioneQueryEntity> {
    RuoliApplicazioneQueryEntity findByCodiceAndApplicazioniId(String codice, String applicazioniId);
    List<RuoliApplicazioneQueryEntity> findAllByCodiceAndApplicazioniId(String codice, String applicazioniId);
    List<RuoliApplicazioneQueryEntity> findAllByApplicazioniId(String applicazioniId);
}
