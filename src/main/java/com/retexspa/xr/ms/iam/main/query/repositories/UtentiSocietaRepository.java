package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.UtentiSocietaQueryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;




public interface UtentiSocietaRepository extends
        JpaRepository<UtentiSocietaQueryEntity, String>, JpaSpecificationExecutor<UtentiSocietaQueryEntity> {
    UtentiSocietaQueryEntity findByUtenteIdAndSocietaIdAndMatricolaAndUpn(String utenteId, String societaId, String matricola, String upn);
    List<UtentiSocietaQueryEntity> findAllByUtenteIdAndSocietaIdAndMatricolaAndUpn(String utenteId, String societaId, String matricola, String upn);

    Page<UtentiSocietaQueryEntity> findBySocietaId(String societaId, Pageable pageable);
    List<UtentiSocietaQueryEntity> findAllBySocietaId(String id);
}
