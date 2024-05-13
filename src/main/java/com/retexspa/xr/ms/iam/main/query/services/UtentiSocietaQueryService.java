package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.UtentiSocietaFilter;
import com.retexspa.xr.ms.iam.main.core.responses.utentiSocieta.UtentiSocietaResponse;
import com.retexspa.xr.ms.iam.main.query.entities.UtentiSocietaQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface UtentiSocietaQueryService {
    Page<UtentiSocietaQueryEntity> searchQueryUtentiSocieta(GenericSearchRequest<UtentiSocietaFilter> query);
    UtentiSocietaResponse searchUtentiSocieta(GenericSearchRequest<UtentiSocietaFilter> query);
}
