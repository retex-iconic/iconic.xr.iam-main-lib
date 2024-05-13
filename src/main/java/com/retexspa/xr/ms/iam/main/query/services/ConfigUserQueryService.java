package com.retexspa.xr.ms.iam.main.query.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.retexspa.xr.ms.iam.main.core.searchRequest.ConfigUserSearchRequest;

public interface ConfigUserQueryService {
    
    public String getConfigUser(ConfigUserSearchRequest query) throws JsonProcessingException;
}
