package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.AttributiRuoliFilter;
import com.retexspa.xr.ms.iam.main.core.responses.attributiRuoli.AttributiRuoliResponse;
import com.retexspa.xr.ms.iam.main.query.entities.AttributiRuoliQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface AttributiRuoliQueryService {

    Page<AttributiRuoliQueryEntity> searchQueryAttributiRuoli(GenericSearchRequest<AttributiRuoliFilter> query);
    AttributiRuoliResponse searchAttributiRuoli(GenericSearchRequest<AttributiRuoliFilter> query);
}
