package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.ContestiApplicazioniQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ContestiApplicazioniRepository
        extends JpaRepository<ContestiApplicazioniQueryEntity, String>, JpaSpecificationExecutor<ContestiApplicazioniQueryEntity> {
    ContestiApplicazioniQueryEntity findByCodiceAndTipoContestoApplicazioneId(String codice, String tipoContestoApplicazioneId);
    List<ContestiApplicazioniQueryEntity> findAllByCodiceAndTipoContestoApplicazioneId(String codice, String tipoContestoApplicazioneId);
    List<ContestiApplicazioniQueryEntity> findAllByTipoContestoApplicazioneId(String id);
}
