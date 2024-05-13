package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.AttributiUtentiQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttributiUtentiRepository
        extends JpaRepository<AttributiUtentiQueryEntity, String>, JpaSpecificationExecutor<AttributiUtentiQueryEntity> {}
