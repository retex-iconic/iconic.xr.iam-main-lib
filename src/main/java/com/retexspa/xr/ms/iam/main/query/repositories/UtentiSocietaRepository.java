package com.retexspa.xr.ms.iam.main.query.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.retexspa.xr.ms.iam.main.query.entities.UtentiSocietaQueryEntity;




public interface UtentiSocietaRepository extends
        JpaRepository<UtentiSocietaQueryEntity, String>, JpaSpecificationExecutor<UtentiSocietaQueryEntity> {
    UtentiSocietaQueryEntity findByUtenteIdAndSocietaIdAndMatricolaAndUpn(String utenteId, String societaId, String matricola, String upn);
    List<UtentiSocietaQueryEntity> findAllByUtenteIdAndSocietaIdAndMatricolaAndUpn(String utenteId, String societaId, String matricola, String upn);

    Page<UtentiSocietaQueryEntity> findBySocietaId(String societaId, Pageable pageable);
    List<UtentiSocietaQueryEntity> findAllBySocietaId(String id);
    List<UtentiSocietaQueryEntity> findAllByBadgeSocietaId(String id);
    List<UtentiSocietaQueryEntity> findAllByUtenteId(String id);
}
