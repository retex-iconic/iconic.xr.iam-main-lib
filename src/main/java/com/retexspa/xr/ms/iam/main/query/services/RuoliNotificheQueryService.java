package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.RuoliNotificheFilter;
import com.retexspa.xr.ms.iam.main.core.responses.ruoliNotifiche.RuoliNotificheResponse;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliNotificheQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface RuoliNotificheQueryService {
    Page<RuoliNotificheQueryEntity> searchQueryRuoliNotifiche(GenericSearchRequest<RuoliNotificheFilter> query);
    RuoliNotificheResponse searchRuoliNotifiche(GenericSearchRequest<RuoliNotificheFilter> query);
}

