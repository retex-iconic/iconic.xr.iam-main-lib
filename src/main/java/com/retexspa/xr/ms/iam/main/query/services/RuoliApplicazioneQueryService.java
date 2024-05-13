package com.retexspa.xr.ms.iam.main.query.services;


import com.retexspa.xr.ms.iam.main.core.filterRequest.RuoliApplicazioneFilter;
import com.retexspa.xr.ms.iam.main.core.responses.ruoliApplicazione.RuoliApplicazioneResponse;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliApplicazioneQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface RuoliApplicazioneQueryService {
    Page<RuoliApplicazioneQueryEntity> searchQueryRuoliApplicazione(GenericSearchRequest<RuoliApplicazioneFilter> query);
    RuoliApplicazioneResponse searchRuoliApplicazione(GenericSearchRequest<RuoliApplicazioneFilter>query);
}
