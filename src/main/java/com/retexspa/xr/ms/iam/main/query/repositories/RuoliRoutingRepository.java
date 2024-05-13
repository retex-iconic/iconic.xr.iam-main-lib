package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.RuoliRoutingQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RuoliRoutingRepository extends JpaRepository<RuoliRoutingQueryEntity, String>, JpaSpecificationExecutor<RuoliRoutingQueryEntity> {
    RuoliRoutingQueryEntity findByRoutingIdAndRuoloId(String menuCharId, String routingId);
    List<RuoliRoutingQueryEntity> findAllByRoutingIdAndRuoloId(String menuCharId, String routingId);
}
