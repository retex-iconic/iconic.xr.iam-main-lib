package com.retexspa.xr.ms.iam.main.core.responses.ruoliNotifiche;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.ruoliNotifiche.RuoliNotificheBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class RuoliNotificheAggregateResponse extends BaseAggregateResponse<RuoliNotificheBaseDTO> {

    private Map<String, Object> lastEvent;

    public RuoliNotificheAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data") RuoliNotificheBaseDTO data,
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
