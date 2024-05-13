package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.TipiContestoApplicazioneFilter;
import com.retexspa.xr.ms.iam.main.core.responses.tipiContestoApplicazione.TipiContestoApplicazioneResponse;
import com.retexspa.xr.ms.iam.main.query.entities.TipiContestoApplicazioneQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface TipiContestoApplicazioneQueryService  {
    Page<TipiContestoApplicazioneQueryEntity> searchQueryTipiContestoApplicazione(GenericSearchRequest<TipiContestoApplicazioneFilter> query);
    TipiContestoApplicazioneResponse searchTipiContestoApplicazione(GenericSearchRequest<TipiContestoApplicazioneFilter> query);
}
