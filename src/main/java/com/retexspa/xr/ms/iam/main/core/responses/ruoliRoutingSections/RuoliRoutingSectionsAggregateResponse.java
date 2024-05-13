package com.retexspa.xr.ms.iam.main.core.responses.ruoliRoutingSections;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.ruoliRoutingSections.RuoliRoutingSectionsBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class RuoliRoutingSectionsAggregateResponse extends BaseAggregateResponse<RuoliRoutingSectionsBaseDTO> {

    private Map<String, Object> lastEvent;

    public RuoliRoutingSectionsAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data")  RuoliRoutingSectionsBaseDTO data,
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
