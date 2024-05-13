package com.retexspa.xr.ms.iam.main.core.responses.utentiSocieta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.utentiSocieta.UtentiSocietaBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class UtentiSocietaAggregateResponse extends BaseAggregateResponse<UtentiSocietaBaseDTO> {

    private Map<String, Object> lastEvent;

    public UtentiSocietaAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data")  UtentiSocietaBaseDTO data,
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
