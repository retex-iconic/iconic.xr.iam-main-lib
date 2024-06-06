package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.responses.sostituzioniBadge.SostituzioniBadgeResponse;
import com.retexspa.xr.ms.iam.main.core.searchRequest.SostituzioniBadgeSearchRequest;
import com.retexspa.xr.ms.iam.main.query.entities.SostituzioniBadgeQueryEntity;
import org.springframework.data.domain.Page;

public interface SostituzioniBadgeQueryService {

    Page<SostituzioniBadgeQueryEntity> searchQuerySostituzioniBadge(SostituzioniBadgeSearchRequest query);
    SostituzioniBadgeResponse searchSostituzioniBadge(SostituzioniBadgeSearchRequest query);
}
