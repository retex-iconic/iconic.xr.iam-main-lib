package com.retexspa.xr.ms.iam.main.core.responses.tipiContestoApplicazione;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.tipiContestoApplicazione.TipiContestoApplicazioneBaseDTO;
import com.retexspa.xr.ms.main.core.responses.BaseAggregateResponse;

import java.util.Map;

public class TipiContestoApplicazioneAggregateResponse extends BaseAggregateResponse<TipiContestoApplicazioneBaseDTO> {

    private Map<String, Object> lastEvent;

    public TipiContestoApplicazioneAggregateResponse(
            @JsonProperty("id") String id,
            @JsonProperty("version") Long version,
            @JsonProperty("data")  TipiContestoApplicazioneBaseDTO data,
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
