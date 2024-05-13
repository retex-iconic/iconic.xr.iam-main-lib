package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.TipiContestoApplicazioneQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TipiContestoApplicazioneRepository
        extends JpaRepository<TipiContestoApplicazioneQueryEntity, String>, JpaSpecificationExecutor<TipiContestoApplicazioneQueryEntity> {
    TipiContestoApplicazioneQueryEntity findByTipiContestoIdAndApplicazioneId(String tipiContestoId, String applicazioneId);
    List<TipiContestoApplicazioneQueryEntity> findAllByTipiContestoIdAndApplicazioneId(String tipiContestoId, String applicazioneId);
}
