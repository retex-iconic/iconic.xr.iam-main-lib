package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.MenuQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuQueryEntity, String>, JpaSpecificationExecutor<MenuQueryEntity> {
    MenuQueryEntity findByMenuCharIdAndRoutingId(String menuCharId, String routingId);
    List<MenuQueryEntity> findAllByMenuCharIdAndRoutingId(String menuCharId, String routingId);
    List<MenuQueryEntity> findAllByRoutingId(String id);
    List<MenuQueryEntity> findAllByNodoId(String id);
}
