package com.retexspa.xr.ms.iam.main.core.queries.utentiApplicazioni;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UtentiApplicazioniAggregateGetEventsByIdQuery {

    private String utentiApplicazioniId;

    public UtentiApplicazioniAggregateGetEventsByIdQuery(@JsonProperty("utentiApplicazioniId") String utentiApplicazioniId) {
        this.utentiApplicazioniId = utentiApplicazioniId;
    }

    public String getUtentiApplicazioniId() {
        return utentiApplicazioniId;
    }

    public void setUtentiApplicazioniId(String utentiApplicazioniId) {
        this.utentiApplicazioniId = utentiApplicazioniId;
    }
}
