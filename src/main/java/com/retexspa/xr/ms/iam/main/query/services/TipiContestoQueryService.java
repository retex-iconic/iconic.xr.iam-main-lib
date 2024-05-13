package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.TipiContestoFilter;
import com.retexspa.xr.ms.iam.main.core.responses.tipiContesto.TipiContestoResponse;
import com.retexspa.xr.ms.iam.main.query.entities.TipiContestoQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface TipiContestoQueryService  {
    Page<TipiContestoQueryEntity> searchQueryTipiContesto(GenericSearchRequest<TipiContestoFilter> query);
    TipiContestoResponse searchTipiContesto(GenericSearchRequest<TipiContestoFilter> query);
}
