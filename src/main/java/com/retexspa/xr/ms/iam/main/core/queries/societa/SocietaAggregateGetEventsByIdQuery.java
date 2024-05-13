package com.retexspa.xr.ms.iam.main.core.queries.societa;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SocietaAggregateGetEventsByIdQuery {
    private String societaId;

    public SocietaAggregateGetEventsByIdQuery(@JsonProperty("societaId") String societaId) {
        this.societaId = societaId;
    }

    public String getSocietaId() {
        return societaId;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
    }
}

