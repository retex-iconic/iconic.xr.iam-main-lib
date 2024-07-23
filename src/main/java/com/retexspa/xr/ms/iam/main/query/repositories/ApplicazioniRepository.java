package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.ApplicazioniQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ApplicazioniRepository
        extends JpaRepository<ApplicazioniQueryEntity, String>, JpaSpecificationExecutor<ApplicazioniQueryEntity> {
    ApplicazioniQueryEntity findByCodiceAndSocietaId(String codice, String societaId);
    List<ApplicazioniQueryEntity> findAllByCodiceAndSocietaId(String codice,String societaId);

    public List<ApplicazioniQueryEntity> findAllBySocietaId(String id);
}
