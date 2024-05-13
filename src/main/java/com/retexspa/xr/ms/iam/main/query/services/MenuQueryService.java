package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.MenuFilter;
import com.retexspa.xr.ms.iam.main.core.responses.menu.MenuResponse;
import com.retexspa.xr.ms.iam.main.query.entities.MenuQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface MenuQueryService {
    Page<MenuQueryEntity> searchQueryMenu(GenericSearchRequest<MenuFilter> query);
    MenuResponse searchMenu(GenericSearchRequest<MenuFilter> query);
}
