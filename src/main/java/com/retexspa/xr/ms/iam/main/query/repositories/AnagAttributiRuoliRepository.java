package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.AnagAttributiRuoliQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AnagAttributiRuoliRepository extends JpaRepository<AnagAttributiRuoliQueryEntity, String>, JpaSpecificationExecutor<AnagAttributiRuoliQueryEntity> {

}
