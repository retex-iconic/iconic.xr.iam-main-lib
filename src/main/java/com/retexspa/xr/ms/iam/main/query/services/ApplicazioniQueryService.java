package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.ApplicazioniFilter;
import com.retexspa.xr.ms.iam.main.core.responses.applicazioni.ApplicazioniResponse;
import com.retexspa.xr.ms.iam.main.query.entities.ApplicazioniQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ApplicazioniQueryService {
    Page<ApplicazioniQueryEntity> searchQueryApplicazioni(GenericSearchRequest<ApplicazioniFilter> query);
    List<ApplicazioniQueryEntity> findAllIconicApplicazioni();
    ApplicazioniResponse searchApplicazioni(GenericSearchRequest<ApplicazioniFilter> query);
}
