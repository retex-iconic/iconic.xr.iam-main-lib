package com.retexspa.xr.ms.iam.main.core.queries.badgeSocieta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BadgeSocietaAggregateGetByIdQuery {
    private String badgeSocietaId;

    public BadgeSocietaAggregateGetByIdQuery(@JsonProperty("badgeSocietaId") String badgeSocietaId) {
        this.badgeSocietaId = badgeSocietaId;
    }

    public String getBadgeSocietaId() {
        return badgeSocietaId;
    }

    public void setBadgeSocietaId(String badgeSocietaId) {
        this.badgeSocietaId = badgeSocietaId;
    }
}
