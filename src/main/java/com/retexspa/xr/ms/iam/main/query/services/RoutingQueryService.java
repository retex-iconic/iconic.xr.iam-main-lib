package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.responses.routing.RoutingResponse;
import com.retexspa.xr.ms.iam.main.core.searchRequest.RoutingSearchRequest;
import com.retexspa.xr.ms.iam.main.query.entities.RoutingQueryEntity;
import org.springframework.data.domain.Page;

public interface RoutingQueryService  {
    Page<RoutingQueryEntity> searchQueryRouting(RoutingSearchRequest query);
    RoutingResponse searchRouting(RoutingSearchRequest query);
}
