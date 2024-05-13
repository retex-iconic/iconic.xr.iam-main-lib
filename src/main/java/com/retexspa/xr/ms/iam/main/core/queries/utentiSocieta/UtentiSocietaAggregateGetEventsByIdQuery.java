package com.retexspa.xr.ms.iam.main.core.queries.utentiSocieta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UtentiSocietaAggregateGetEventsByIdQuery {
    private String utentiSocietaId;

    public UtentiSocietaAggregateGetEventsByIdQuery(@JsonProperty("utentiSocietaId") String utentiSocietaId) {
        this.utentiSocietaId = utentiSocietaId;
    }

    public String getUtentiSocietaId() {
        return utentiSocietaId;
    }

    public void setUtentiSocietaId(String utentiSocietaId) {
        this.utentiSocietaId = utentiSocietaId;
    }
}
