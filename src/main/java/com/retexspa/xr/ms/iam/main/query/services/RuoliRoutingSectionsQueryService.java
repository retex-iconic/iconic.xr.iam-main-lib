package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.RuoliRoutingSectionsFilter;
import com.retexspa.xr.ms.iam.main.core.responses.ruoliRoutingSections.RuoliRoutingSectionsResponse;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliRoutingSectionsQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface RuoliRoutingSectionsQueryService {
    Page<RuoliRoutingSectionsQueryEntity> searchQueryRuoliRoutingSections(GenericSearchRequest<RuoliRoutingSectionsFilter> query);
    RuoliRoutingSectionsResponse searchRuoliRoutingSections(GenericSearchRequest<RuoliRoutingSectionsFilter> query);
}
