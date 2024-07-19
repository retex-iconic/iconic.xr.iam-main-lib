package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.RoutingFilter;
import com.retexspa.xr.ms.iam.main.core.responses.routing.RoutingResponse;
import com.retexspa.xr.ms.iam.main.query.entities.RoutingQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface RoutingQueryService  {
    Page<RoutingQueryEntity> searchQueryRouting(GenericSearchRequest<RoutingFilter> query);
    RoutingResponse searchRouting(GenericSearchRequest<RoutingFilter>  query);
}
