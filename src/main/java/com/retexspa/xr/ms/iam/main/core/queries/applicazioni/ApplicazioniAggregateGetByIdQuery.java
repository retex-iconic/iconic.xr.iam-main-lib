package com.retexspa.xr.ms.iam.main.core.queries.applicazioni;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicazioniAggregateGetByIdQuery {
    private String applicazioniId;

    public ApplicazioniAggregateGetByIdQuery(@JsonProperty("applicazioniId") String applicazioniId) {
        this.applicazioniId = applicazioniId;
    }

    public String getApplicazioniId() {
        return applicazioniId;
    }

    public void setApplicazioniId(String applicazioniId) {
        this.applicazioniId = applicazioniId;
    }
}
