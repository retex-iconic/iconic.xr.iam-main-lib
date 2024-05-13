package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.AttributiUtentiFilter;
import com.retexspa.xr.ms.iam.main.core.responses.attributiUtenti.AttributiUtentiResponse;
import com.retexspa.xr.ms.iam.main.query.entities.AttributiUtentiQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface AttributiUtentiQueryService {
    Page<AttributiUtentiQueryEntity> searchQueryAttributiUtenti(GenericSearchRequest<AttributiUtentiFilter> query);
    AttributiUtentiResponse searchAttributiUtenti(GenericSearchRequest<AttributiUtentiFilter> query);
}
