package com.retexspa.xr.ms.iam.main.query.repositories;

import com.retexspa.xr.ms.iam.main.query.entities.SostituzioniBadgeQueryEntity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SostituzioniBadgeRepository
        extends JpaRepository<SostituzioniBadgeQueryEntity, String>, JpaSpecificationExecutor<SostituzioniBadgeQueryEntity> {

                List<SostituzioniBadgeQueryEntity> findAllByBadgeSocietaId(String id);

                List<SostituzioniBadgeQueryEntity> findAllByUtentiId(String id);

                SostituzioniBadgeQueryEntity findByUtentiIdAndBadgeIdAndDataSblocco(String utentiSocietaId, String badgeId, LocalDateTime dataSblocco);
}
