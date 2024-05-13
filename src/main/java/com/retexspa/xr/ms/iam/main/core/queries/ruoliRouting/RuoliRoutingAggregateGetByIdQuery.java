package com.retexspa.xr.ms.iam.main.core.queries.ruoliRouting;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RuoliRoutingAggregateGetByIdQuery {
    private String ruoliRoutingId;

    public RuoliRoutingAggregateGetByIdQuery (@JsonProperty("ruoliRoutingId") String ruoliRoutingId) {
        this.ruoliRoutingId = ruoliRoutingId;
    }

    public String getRuoliRoutingId() {
        return ruoliRoutingId;
    }

    public void setRuoliRoutingId(String ruoliRoutingId) {
        this.ruoliRoutingId = ruoliRoutingId;
    }
}

