package com.retexspa.xr.ms.iam.main.core.responses.utentiApplicazioni;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.utentiApplicazioni.UtentiApplicazioniBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class UtentiApplicazioniAggregateResponse extends BaseAggregateResponse<UtentiApplicazioniBaseDTO> {

    private Map<String, Object> lastEvent;

    public UtentiApplicazioniAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data")  UtentiApplicazioniBaseDTO data,
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
