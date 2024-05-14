package com.retexspa.xr.ms.iam.main.query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.retexspa.xr.ms.iam.main.query.entities.IconicApplicazioniQueryEntity;

import java.util.List;

public interface IconicApplicazioniRepository
        extends JpaRepository<IconicApplicazioniQueryEntity, String>, JpaSpecificationExecutor<IconicApplicazioniQueryEntity> {
    IconicApplicazioniQueryEntity findByCodice(String codice);
    List<IconicApplicazioniQueryEntity> findAllByCodice(String codice);
}
