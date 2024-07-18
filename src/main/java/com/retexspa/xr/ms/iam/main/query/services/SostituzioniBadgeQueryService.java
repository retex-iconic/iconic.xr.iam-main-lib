package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.SostituzioniBadgeFilter;
import com.retexspa.xr.ms.iam.main.core.responses.sostituzioniBadge.SostituzioniBadgeResponse;

import com.retexspa.xr.ms.iam.main.query.entities.SostituzioniBadgeQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;

import org.springframework.data.domain.Page;

public interface SostituzioniBadgeQueryService {

    Page<SostituzioniBadgeQueryEntity> searchQuerySostituzioniBadge(GenericSearchRequest<SostituzioniBadgeFilter> query);
    SostituzioniBadgeResponse searchSostituzioniBadge(GenericSearchRequest<SostituzioniBadgeFilter> query);
}
