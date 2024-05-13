package com.retexspa.xr.ms.iam.main.core.queries.badgeSocieta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BadgeSocietaAggregateGetEventsByIdQuery {

    private String badgeSocietaId;

    public BadgeSocietaAggregateGetEventsByIdQuery(@JsonProperty("badgeSocietaId") String badgeSocietaId) {
        this.badgeSocietaId = badgeSocietaId;
    }

    public String getBadgeSocietaId() {
        return badgeSocietaId;
    }

    public void setBadgeSocietaId(String badgeSocietaId) {
        this.badgeSocietaId = badgeSocietaId;
    }
}
