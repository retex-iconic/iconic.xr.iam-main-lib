package com.retexspa.xr.ms.iam.main.core.responses.societa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.societa.SocietaBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class SocietaAggregateResponse extends BaseAggregateResponse<SocietaBaseDTO> {

    private Map<String, Object> lastEvent;

    public SocietaAggregateResponse(
            @JsonProperty("id") String id, 
            @JsonProperty("version") Long version,
            @JsonProperty("data")  SocietaBaseDTO data,
            @JsonProperty("lastEvent")  Map<String, Object> lastEvent) {
        super(id, version, data);
        this.lastEvent = lastEvent;
    }

    public Map<String, Object> getLastEvent() {
        return lastEvent;
    }

    public void setLastEvent(Map<String, Object> lastEvent) {
        this.lastEvent = lastEvent;
    }
}
