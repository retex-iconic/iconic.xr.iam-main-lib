package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.AnagAttributiUtentiQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AnagAttributiUtentiRepository
        extends JpaRepository<AnagAttributiUtentiQueryEntity, String>, JpaSpecificationExecutor<AnagAttributiUtentiQueryEntity> {}
