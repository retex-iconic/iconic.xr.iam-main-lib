package com.retexspa.xr.ms.iam.main.core.queries.applicazioni;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicazioniAggregateGetEventsByIdQuery {
    private String applicazioniId;

    public ApplicazioniAggregateGetEventsByIdQuery(@JsonProperty("applicazioniId") String applicazioniId) {
        this.applicazioniId = applicazioniId;
    }

    public String getApplicazioniId() {
        return applicazioniId;
    }

    public void setApplicazioniId(String applicazioniId) {
        this.applicazioniId = applicazioniId;
    }
}
