package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.UtentiQueryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UtentiRepository extends
        JpaRepository<UtentiQueryEntity, String>, JpaSpecificationExecutor<UtentiQueryEntity> {
    UtentiQueryEntity findByIdAccount(String idAccount);
}
