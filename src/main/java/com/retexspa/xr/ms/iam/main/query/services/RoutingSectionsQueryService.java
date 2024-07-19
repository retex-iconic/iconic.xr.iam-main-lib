package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.RoutingSectionsFilter;
import com.retexspa.xr.ms.iam.main.core.responses.routingSections.RoutingSectionsResponse;
import com.retexspa.xr.ms.iam.main.query.entities.RoutingSectionsQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface RoutingSectionsQueryService  {
    Page<RoutingSectionsQueryEntity> searchQueryRoutingSections(GenericSearchRequest<RoutingSectionsFilter> query);
    RoutingSectionsResponse searchRoutingSections(GenericSearchRequest<RoutingSectionsFilter> query);
}
