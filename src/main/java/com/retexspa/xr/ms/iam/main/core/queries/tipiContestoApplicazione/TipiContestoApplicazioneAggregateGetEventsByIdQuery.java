package com.retexspa.xr.ms.iam.main.core.queries.tipiContestoApplicazione;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipiContestoApplicazioneAggregateGetEventsByIdQuery {
    private String tipiContestoApplicazioneId;

    public TipiContestoApplicazioneAggregateGetEventsByIdQuery(@JsonProperty("tipiContestoApplicazioneId") String tipiContestoApplicazioneId) {
        this.tipiContestoApplicazioneId = tipiContestoApplicazioneId;
    }

    public String getTipiContestoApplicazioneId() {
        return tipiContestoApplicazioneId;
    }

    public void setTipiContestoApplicazioneId(String tipiContestoApplicazioneId) {
        this.tipiContestoApplicazioneId = tipiContestoApplicazioneId;
    }
}
