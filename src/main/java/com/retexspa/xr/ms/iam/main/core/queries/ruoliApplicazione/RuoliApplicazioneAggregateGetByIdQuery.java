package com.retexspa.xr.ms.iam.main.core.queries.ruoliApplicazione;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RuoliApplicazioneAggregateGetByIdQuery {

    private String ruoliApplicazioneId;

    public RuoliApplicazioneAggregateGetByIdQuery(@JsonProperty("ruoliApplicazioneId") String ruoliApplicazioneId) {
        this.ruoliApplicazioneId = ruoliApplicazioneId;
    }

    public String getRuoliApplicazioneId() {
        return ruoliApplicazioneId;
    }

    public void setRuoliApplicazioneId(String ruoliApplicazioneId) {
        this.ruoliApplicazioneId = ruoliApplicazioneId;
    }
}

