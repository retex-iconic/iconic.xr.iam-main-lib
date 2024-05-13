package com.retexspa.xr.ms.iam.main.core.queries.sostituzioniBadge;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SostituzioniBadgeAggregateGetEventsByIdQuery {

    private String sostituzioniBadgeId;

    public SostituzioniBadgeAggregateGetEventsByIdQuery(@JsonProperty("sostituzioniBadgeId") String sostituzioniBadgeId) {
        this.sostituzioniBadgeId = sostituzioniBadgeId;
    }

    public String getSostituzioniBadgeId() {
        return sostituzioniBadgeId;
    }

    public void setSostituzioniBadgeId(String sostituzioniBadgeId) {
        this.sostituzioniBadgeId = sostituzioniBadgeId;
    }
}
