package com.retexspa.xr.ms.iam.main.core.responses.ruoliApplicazione;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.ruoliApplicazione.RuoliApplicazioneBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;


import java.util.Map;

public class RuoliApplicazioneAggregateResponse extends BaseAggregateResponse<RuoliApplicazioneBaseDTO> {

    private Map<String, Object> lastEvent;

    public RuoliApplicazioneAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data")  RuoliApplicazioneBaseDTO data,
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
