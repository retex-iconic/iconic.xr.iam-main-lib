package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.SocietaQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SocietaRepository
    extends JpaRepository<SocietaQueryEntity, String>, JpaSpecificationExecutor<SocietaQueryEntity> {
  SocietaQueryEntity findByCodice(String codice);
  List<SocietaQueryEntity> findAllByCodice(String codice);
}
