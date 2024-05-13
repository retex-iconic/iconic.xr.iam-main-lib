package com.retexspa.xr.ms.iam.main.core.responses.attributiUtenti;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.attributiUtenti.AttributiUtentiBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class AttributiUtentiAggregateResponse extends BaseAggregateResponse<AttributiUtentiBaseDTO> {

    private Map<String, Object> lastEvent;

    public AttributiUtentiAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data")  AttributiUtentiBaseDTO data,
            @JsonProperty("lastEvent") Map<String, Object> lastEvent) {
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
