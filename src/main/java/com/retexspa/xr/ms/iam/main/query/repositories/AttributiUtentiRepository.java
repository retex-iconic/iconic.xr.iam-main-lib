package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.AttributiUtentiQueryEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttributiUtentiRepository
        extends JpaRepository<AttributiUtentiQueryEntity, String>, JpaSpecificationExecutor<AttributiUtentiQueryEntity> {

    List<AttributiUtentiQueryEntity> findAllByUtenteApplicazioneId(String id);}
