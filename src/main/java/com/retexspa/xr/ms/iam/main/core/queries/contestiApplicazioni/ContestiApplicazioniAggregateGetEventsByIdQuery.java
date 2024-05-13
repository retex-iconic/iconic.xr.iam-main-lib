package com.retexspa.xr.ms.iam.main.core.queries.contestiApplicazioni;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContestiApplicazioniAggregateGetEventsByIdQuery {
    private String contestiApplicazioneId;

    public ContestiApplicazioniAggregateGetEventsByIdQuery(@JsonProperty("contestiApplicazioneId") String contestiApplicazioneId) {
        this.contestiApplicazioneId = contestiApplicazioneId;
    }

    public String getContestiApplicazioniId() {
        return contestiApplicazioneId;
    }

    public void setContestiApplicazioniId(String contestiApplicazioneId) {
        this.contestiApplicazioneId = contestiApplicazioneId;
    }
}
