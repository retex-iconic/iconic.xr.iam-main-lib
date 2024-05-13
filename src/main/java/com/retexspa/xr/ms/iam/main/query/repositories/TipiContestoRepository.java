package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.TipiContestoQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TipiContestoRepository
        extends JpaRepository<TipiContestoQueryEntity, String>, JpaSpecificationExecutor<TipiContestoQueryEntity> {
    TipiContestoQueryEntity findByCodiceAndId(String codice, String Id);
    List<TipiContestoQueryEntity> findAllByCodiceAndId(String codice, String Id);
}
