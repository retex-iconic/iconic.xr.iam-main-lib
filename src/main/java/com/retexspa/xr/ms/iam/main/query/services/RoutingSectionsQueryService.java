package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.responses.routingSections.RoutingSectionsResponse;
import com.retexspa.xr.ms.iam.main.core.searchRequest.RoutingSectionsSearchRequest;
import com.retexspa.xr.ms.iam.main.query.entities.RoutingSectionsQueryEntity;
import org.springframework.data.domain.Page;

public interface RoutingSectionsQueryService  {
    Page<RoutingSectionsQueryEntity> searchQueryRoutingSections(RoutingSectionsSearchRequest query);
    RoutingSectionsResponse searchRoutingSections(RoutingSectionsSearchRequest query);
}
