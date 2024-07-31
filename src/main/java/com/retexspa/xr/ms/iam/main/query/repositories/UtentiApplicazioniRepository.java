package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.UtentiApplicazioniQueryEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UtentiApplicazioniRepository extends JpaRepository<UtentiApplicazioniQueryEntity, String>, JpaSpecificationExecutor<UtentiApplicazioniQueryEntity> {

    List<UtentiApplicazioniQueryEntity> findAllByUtenteId(String id);

    List<UtentiApplicazioniQueryEntity> findAllByContestoId(String id);

    List<UtentiApplicazioniQueryEntity> findAllByRuoloId(String id);

}
