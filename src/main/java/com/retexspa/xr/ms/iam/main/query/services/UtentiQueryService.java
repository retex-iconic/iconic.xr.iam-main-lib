package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.UtentiFilter;
import com.retexspa.xr.ms.iam.main.core.responses.utenti.UtentiResponse;
import com.retexspa.xr.ms.iam.main.query.entities.UtentiQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface UtentiQueryService {
    Page<UtentiQueryEntity> searchQueryUtenti(GenericSearchRequest<UtentiFilter> query);
    UtentiResponse searchUtenti(GenericSearchRequest<UtentiFilter> query);
}
