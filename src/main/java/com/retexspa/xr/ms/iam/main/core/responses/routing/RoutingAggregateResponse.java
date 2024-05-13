package com.retexspa.xr.ms.iam.main.core.responses.routing;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.routing.RoutingBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class RoutingAggregateResponse extends BaseAggregateResponse<RoutingBaseDTO> {

    private Map<String, Object> lastEvent;

    public RoutingAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data")  RoutingBaseDTO data,
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
