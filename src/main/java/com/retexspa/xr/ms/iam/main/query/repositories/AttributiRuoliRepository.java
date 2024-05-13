package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.AttributiRuoliQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttributiRuoliRepository extends JpaRepository<AttributiRuoliQueryEntity, String>, JpaSpecificationExecutor<AttributiRuoliQueryEntity> {

}
