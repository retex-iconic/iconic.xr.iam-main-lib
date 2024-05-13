package com.retexspa.xr.ms.iam.main.core.responses.contestiApplicazioni;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.contestiApplicazioni.ContestiApplicazioniBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class ContestiApplicazioniAggregateResponse extends BaseAggregateResponse<ContestiApplicazioniBaseDTO> {

    private Map<String, Object> lastEvent;

    public ContestiApplicazioniAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data") ContestiApplicazioniBaseDTO data,
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
