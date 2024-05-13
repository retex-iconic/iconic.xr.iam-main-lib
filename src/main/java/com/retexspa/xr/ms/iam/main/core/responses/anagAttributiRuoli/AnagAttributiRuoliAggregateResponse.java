package com.retexspa.xr.ms.iam.main.core.responses.anagAttributiRuoli;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.anagAttributiRuoli.AnagAttributiRuoliBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class AnagAttributiRuoliAggregateResponse extends BaseAggregateResponse<AnagAttributiRuoliBaseDTO> {

    private Map<String, Object> lastEvent;

    public AnagAttributiRuoliAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data")  AnagAttributiRuoliBaseDTO data,
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
