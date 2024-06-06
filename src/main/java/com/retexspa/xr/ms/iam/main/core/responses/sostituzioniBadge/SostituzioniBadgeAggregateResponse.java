package com.retexspa.xr.ms.iam.main.core.responses.sostituzioniBadge;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.sostituzioniBadge.SostituzioniBadgeBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class SostituzioniBadgeAggregateResponse extends BaseAggregateResponse<SostituzioniBadgeBaseDTO> {

    private Map<String, Object> lastEvent;

    public SostituzioniBadgeAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data")  SostituzioniBadgeBaseDTO data,
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
