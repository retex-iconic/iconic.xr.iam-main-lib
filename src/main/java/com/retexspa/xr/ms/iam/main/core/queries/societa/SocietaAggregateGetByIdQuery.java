package com.retexspa.xr.ms.iam.main.core.queries.societa;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SocietaAggregateGetByIdQuery {
    private String societaId;

    public SocietaAggregateGetByIdQuery(@JsonProperty("societaId") String societaId) {
        this.societaId = societaId;
    }

    public String getSocietaId() {
        return societaId;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
    }
}