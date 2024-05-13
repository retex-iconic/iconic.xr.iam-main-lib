package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.AnagAttributiRuoliFilter;
import com.retexspa.xr.ms.iam.main.core.responses.anagAttributiRuoli.AnagAttributiRuoliResponse;
import com.retexspa.xr.ms.iam.main.query.entities.AnagAttributiRuoliQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface AnagAttributiRuoliQueryService {

    Page<AnagAttributiRuoliQueryEntity> searchQueryAnagAttributiRuoli(GenericSearchRequest<AnagAttributiRuoliFilter> query);
    AnagAttributiRuoliResponse searchAnagAttributiRuoli(GenericSearchRequest<AnagAttributiRuoliFilter> query);
}
