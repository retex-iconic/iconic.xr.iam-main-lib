package com.retexspa.xr.ms.iam.main.core.queries.sostituzioniBadge;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SostituzioniBadgeAggregateGetByIdQuery {
    private String sostituzioniBadgeId;

    public SostituzioniBadgeAggregateGetByIdQuery(@JsonProperty("sostituzioniBadgeId") String sostituzioniBadgeId) {
        this.sostituzioniBadgeId = sostituzioniBadgeId;
    }

    public String getSostituzioniBadgeId() {
        return sostituzioniBadgeId;
    }

    public void setSostituzioniBadgeId(String sostituzioniBadgeId) {
        this.sostituzioniBadgeId = sostituzioniBadgeId;
    }

}
