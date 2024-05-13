package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.RuoliRoutingFilter;
import com.retexspa.xr.ms.iam.main.core.responses.ruoliRouting.RuoliRoutingResponse;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliRoutingQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface RuoliRoutingQueryService {
    Page<RuoliRoutingQueryEntity> searchQueryRuoliRouting(GenericSearchRequest<RuoliRoutingFilter> query);
    RuoliRoutingResponse searchRuoliRouting(GenericSearchRequest<RuoliRoutingFilter> query);
}
