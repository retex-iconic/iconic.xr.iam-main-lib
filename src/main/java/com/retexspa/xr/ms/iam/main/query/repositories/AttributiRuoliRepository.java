package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.AttributiRuoliQueryEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttributiRuoliRepository extends JpaRepository<AttributiRuoliQueryEntity, String>, JpaSpecificationExecutor<AttributiRuoliQueryEntity> {

    List<AttributiRuoliQueryEntity> findAllByRuoloId(String id);

}
