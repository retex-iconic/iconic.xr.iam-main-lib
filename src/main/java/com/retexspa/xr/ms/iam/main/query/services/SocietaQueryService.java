package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.SocietaFilter;
import com.retexspa.xr.ms.iam.main.core.responses.societa.SocietaResponse;
import com.retexspa.xr.ms.iam.main.query.entities.SocietaQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface SocietaQueryService  {
    Page<SocietaQueryEntity> searchQuerySocieta(GenericSearchRequest<SocietaFilter> query);
    SocietaResponse searchSocieta(GenericSearchRequest<SocietaFilter> query);
}
