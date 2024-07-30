package com.retexspa.xr.ms.iam.main.query.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.retexspa.xr.ms.iam.main.query.entities.TipiContestoApplicazioneQueryEntity;

public interface TipiContestoApplicazioneRepository
        extends JpaRepository<TipiContestoApplicazioneQueryEntity, String>, JpaSpecificationExecutor<TipiContestoApplicazioneQueryEntity> {
    TipiContestoApplicazioneQueryEntity findByTipiContestoIdAndApplicazioneId(String tipiContestoId, String applicazioneId);
    List<TipiContestoApplicazioneQueryEntity> findAllByTipiContestoIdAndApplicazioneId(String tipiContestoId, String applicazioneId);

    List<TipiContestoApplicazioneQueryEntity> findAllByApplicazioneId(String applicazioneId);
    List<TipiContestoApplicazioneQueryEntity> findAllByTipiContestoId(String id);
}
