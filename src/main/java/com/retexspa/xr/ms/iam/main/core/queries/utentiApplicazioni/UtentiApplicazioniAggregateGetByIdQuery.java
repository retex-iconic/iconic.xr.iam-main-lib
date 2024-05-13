package com.retexspa.xr.ms.iam.main.core.queries.utentiApplicazioni;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UtentiApplicazioniAggregateGetByIdQuery {
    private String utentiApplicazioniId;

    public UtentiApplicazioniAggregateGetByIdQuery(@JsonProperty("utentiApplicazioniId") String utentiApplicazioniId) {
        this.utentiApplicazioniId = utentiApplicazioniId;
    }

    public String getUtentiApplicazioniId() {
        return utentiApplicazioniId;
    }

    public void setUtentiApplicazioniId(String utentiApplicazioniId) {
        this.utentiApplicazioniId = utentiApplicazioniId;
    }
}
