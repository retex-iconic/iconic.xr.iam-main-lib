package com.retexspa.xr.ms.iam.main.query.services;


import com.retexspa.xr.ms.iam.main.core.filterRequest.UtentiApplicazioniFilter;
import com.retexspa.xr.ms.iam.main.core.responses.utentiApplicazioni.UtentiApplicazioniResponse;
import com.retexspa.xr.ms.iam.main.query.entities.UtentiApplicazioniQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface UtentiApplicazioniQueryService {

    Page<UtentiApplicazioniQueryEntity> searchQueryUtentiApplicazioni(GenericSearchRequest<UtentiApplicazioniFilter> query);
    UtentiApplicazioniResponse searchUtentiApplicazioni(GenericSearchRequest<UtentiApplicazioniFilter> query);
}
