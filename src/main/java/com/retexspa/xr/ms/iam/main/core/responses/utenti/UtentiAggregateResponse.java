package com.retexspa.xr.ms.iam.main.core.responses.utenti;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.utenti.UtentiBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class UtentiAggregateResponse extends BaseAggregateResponse<UtentiBaseDTO> {

    private Map<String, Object> lastEvent;

    public UtentiAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data")  UtentiBaseDTO data,
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
