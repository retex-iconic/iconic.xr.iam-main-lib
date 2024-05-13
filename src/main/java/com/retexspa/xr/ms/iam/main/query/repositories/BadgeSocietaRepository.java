package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.BadgeSocietaQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BadgeSocietaRepository  extends JpaRepository<BadgeSocietaQueryEntity, String>, JpaSpecificationExecutor<BadgeSocietaQueryEntity> {
    BadgeSocietaQueryEntity findByCodiceBadge(String codiceBadge);
    List<BadgeSocietaQueryEntity> findAllByCodiceBadge(String codiceBadge);
}
