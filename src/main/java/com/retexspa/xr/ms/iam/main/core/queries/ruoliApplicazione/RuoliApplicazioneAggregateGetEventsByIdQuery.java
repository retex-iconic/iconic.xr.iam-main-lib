package com.retexspa.xr.ms.iam.main.core.queries.ruoliApplicazione;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RuoliApplicazioneAggregateGetEventsByIdQuery {
    private String ruoliApplicazioneId;

    public RuoliApplicazioneAggregateGetEventsByIdQuery(@JsonProperty("ruoliApplicazioneId") String ruoliApplicazioneId) {
        this.ruoliApplicazioneId = ruoliApplicazioneId;
    }

    public String getRuoliApplicazioneId() {
        return ruoliApplicazioneId;
    }

    public void setRuoliApplicazioneId(String ruoliApplicazioneId) {
        this.ruoliApplicazioneId = ruoliApplicazioneId;
    }
}