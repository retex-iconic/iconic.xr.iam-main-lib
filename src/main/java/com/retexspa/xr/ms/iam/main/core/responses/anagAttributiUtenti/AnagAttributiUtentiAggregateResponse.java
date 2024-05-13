package com.retexspa.xr.ms.iam.main.core.responses.anagAttributiUtenti;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.anagAttributiUtenti.AnagAttributiUtentiBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class AnagAttributiUtentiAggregateResponse extends BaseAggregateResponse<AnagAttributiUtentiBaseDTO> {

    private Map<String, Object> lastEvent;

    public AnagAttributiUtentiAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data")  AnagAttributiUtentiBaseDTO data,
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
