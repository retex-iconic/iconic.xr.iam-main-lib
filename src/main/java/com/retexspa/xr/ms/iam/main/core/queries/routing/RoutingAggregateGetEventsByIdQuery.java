package com.retexspa.xr.ms.iam.main.core.queries.routing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoutingAggregateGetEventsByIdQuery {
    private String routingId;

    public RoutingAggregateGetEventsByIdQuery(@JsonProperty("routingId") String routingId) {
        this.routingId = routingId;
    }

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }
}
