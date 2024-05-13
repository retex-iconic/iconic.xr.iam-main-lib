package com.retexspa.xr.ms.iam.main.core.queries.tipiContestoApplicazione;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipiContestoApplicazioneAggregateGetByIdQuery {
    private String tipiContestoApplicazioneId;

    public TipiContestoApplicazioneAggregateGetByIdQuery(@JsonProperty("tipiContestoApplicazioneId") String tipiContestoApplicazioneId) {
        this.tipiContestoApplicazioneId = tipiContestoApplicazioneId;
    }

    public String getTipiContestoApplicazioneId() {
        return tipiContestoApplicazioneId;
    }

    public void setTipiContestoApplicazioneId(String tipiContestoApplicazioneId) {
        this.tipiContestoApplicazioneId = tipiContestoApplicazioneId;
    }
}
