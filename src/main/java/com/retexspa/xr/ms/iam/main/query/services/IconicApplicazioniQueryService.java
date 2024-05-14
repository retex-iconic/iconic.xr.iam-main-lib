package com.retexspa.xr.ms.iam.main.query.services;

import org.springframework.data.domain.Page;

import com.retexspa.xr.ms.iam.main.core.filterRequest.IconicApplicazioniFilter;
import com.retexspa.xr.ms.iam.main.core.responses.iconicApplicazioni.IconicApplicazioniResponse;
import com.retexspa.xr.ms.iam.main.query.entities.IconicApplicazioniQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;

public interface IconicApplicazioniQueryService {
    Page<IconicApplicazioniQueryEntity> searchQueryIconicApplicazioni(GenericSearchRequest<IconicApplicazioniFilter> query);

    IconicApplicazioniResponse searchIconicApplicazioni(GenericSearchRequest<IconicApplicazioniFilter> query);
}
