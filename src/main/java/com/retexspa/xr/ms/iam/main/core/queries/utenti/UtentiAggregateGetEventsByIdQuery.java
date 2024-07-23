package com.retexspa.xr.ms.iam.main.core.queries.utenti; 

import com.fasterxml.jackson.annotation.JsonProperty;

public class UtentiAggregateGetEventsByIdQuery {
    private String utentiId;

    public UtentiAggregateGetEventsByIdQuery(@JsonProperty("utentiId") String utentiId) {
        this.utentiId = utentiId;
    }

    public String getUtentiId() {
        return utentiId;
    }

    public void setUtentiId(String utentiId) {
        this.utentiId = utentiId;
    }
}
