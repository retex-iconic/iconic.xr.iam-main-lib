package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.UtentiSocietaQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UtentiSocietaRepository extends
        JpaRepository<UtentiSocietaQueryEntity, String>, JpaSpecificationExecutor<UtentiSocietaQueryEntity> {
    UtentiSocietaQueryEntity findByIdAccountAndSocietaIdAndMatricolaAndUpn(String idAccount, String societaId, String matricola, String upn);
    List<UtentiSocietaQueryEntity> findAllByIdAccountAndSocietaIdAndMatricolaAndUpn(String idAccount, String societaId, String matricola, String upn);
}
