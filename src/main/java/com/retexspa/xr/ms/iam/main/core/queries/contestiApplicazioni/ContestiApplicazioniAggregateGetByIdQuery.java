package com.retexspa.xr.ms.iam.main.core.queries.contestiApplicazioni;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContestiApplicazioniAggregateGetByIdQuery {
    private String contestiApplicazioniId;

    public ContestiApplicazioniAggregateGetByIdQuery(@JsonProperty("contestiApplicazioniId") String contestiApplicazioniId) {
        this.contestiApplicazioniId = contestiApplicazioniId;
    }

    public String getContestiApplicazioniId() {
        return contestiApplicazioniId;
    }

    public void setContestiApplicazioniId(String contestiApplicazioniId) {
        this.contestiApplicazioniId = contestiApplicazioniId;
    }
}

