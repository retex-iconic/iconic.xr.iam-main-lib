package com.retexspa.xr.ms.iam.main.core.responses.iconicApplicazioni;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.iconicApplicazioni.IconicApplicazioniBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class IconicApplicazioniAggregateResponse extends BaseAggregateResponse<IconicApplicazioniBaseDTO> {

    private Map<String, Object> lastEvent;

    public IconicApplicazioniAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data")  IconicApplicazioniBaseDTO data,
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
