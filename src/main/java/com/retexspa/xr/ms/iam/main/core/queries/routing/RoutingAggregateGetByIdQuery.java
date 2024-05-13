package com.retexspa.xr.ms.iam.main.core.queries.routing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoutingAggregateGetByIdQuery {
    private String routingId;

    public RoutingAggregateGetByIdQuery (@JsonProperty("routingId") String routingId) {
        this.routingId = routingId;
    }

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }
}