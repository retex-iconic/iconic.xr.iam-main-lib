package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.RuoliRoutingSectionsQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuoliRoutingSectionsRepository extends JpaRepository<RuoliRoutingSectionsQueryEntity, String>, JpaSpecificationExecutor<RuoliRoutingSectionsQueryEntity> {
    RuoliRoutingSectionsQueryEntity findByRuoliRoutingIdAndRoutingSectionId(String ruoliRoutingId, String routingSectionId);
    List<RuoliRoutingSectionsQueryEntity> findAllByRuoliRoutingIdAndRoutingSectionId(String ruoliRoutingId, String routingSectionId);
    List<RuoliRoutingSectionsQueryEntity> findAllByRoutingSectionId(String id);
}
