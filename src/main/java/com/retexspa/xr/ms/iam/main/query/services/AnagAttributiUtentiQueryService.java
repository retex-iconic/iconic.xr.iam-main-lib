package com.retexspa.xr.ms.iam.main.query.services;

import com.retexspa.xr.ms.iam.main.core.filterRequest.AnagAttributiUtentiFilter;
import com.retexspa.xr.ms.iam.main.core.responses.anagAttributiUtenti.AnagAttributiUtentiResponse;
import com.retexspa.xr.ms.iam.main.query.entities.AnagAttributiUtentiQueryEntity;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import org.springframework.data.domain.Page;

public interface AnagAttributiUtentiQueryService {

    Page<AnagAttributiUtentiQueryEntity> searchQueryAnagAttributiUtenti(GenericSearchRequest<AnagAttributiUtentiFilter> query);
    AnagAttributiUtentiResponse searchAnagAttributiUtenti(GenericSearchRequest<AnagAttributiUtentiFilter> query);
}
