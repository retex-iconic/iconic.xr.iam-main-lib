package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.ContestiApplicazioniFilter;
import com.retexspa.xr.ms.iam.main.core.responses.contestiApplicazioni.ContestiApplicazioniResponse;
import com.retexspa.xr.ms.iam.main.query.entities.ContestiApplicazioniQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface ContestiApplicazioniQueryService {
    Page<ContestiApplicazioniQueryEntity> searchQueryContestiApplicazioni(GenericSearchRequest<ContestiApplicazioniFilter> query);
    ContestiApplicazioniResponse searchContestiApplicazioni(GenericSearchRequest<ContestiApplicazioniFilter> query);
}
