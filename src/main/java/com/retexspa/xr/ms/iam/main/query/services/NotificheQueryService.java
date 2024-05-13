package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.NotificheFilter;
import com.retexspa.xr.ms.iam.main.core.responses.notifiche.NotificheResponse;
import com.retexspa.xr.ms.iam.main.query.entities.NotificheQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface NotificheQueryService {
    Page<NotificheQueryEntity> searchQueryNotifiche(GenericSearchRequest<NotificheFilter> query);
    NotificheResponse searchNotifiche(GenericSearchRequest<NotificheFilter> query);
}
