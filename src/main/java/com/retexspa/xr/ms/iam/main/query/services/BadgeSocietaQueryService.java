package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.BadgeSocietaFilter;
import com.retexspa.xr.ms.iam.main.core.responses.badgeSocieta.BadgeSocietaResponse;
import com.retexspa.xr.ms.iam.main.query.entities.BadgeSocietaQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface BadgeSocietaQueryService {

    Page<BadgeSocietaQueryEntity> searchQueryBadgeSocieta(GenericSearchRequest<BadgeSocietaFilter> query);
    BadgeSocietaResponse searchBadgeSocieta(GenericSearchRequest<BadgeSocietaFilter> query);
}
