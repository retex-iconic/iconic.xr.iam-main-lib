package com.retexspa.xr.ms.iam.main.core.dto.routing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoutingIndexDTO {

    private String routingId;

    public RoutingIndexDTO() {
    }

    public RoutingIndexDTO(String routingId) {
        this.routingId = routingId;
    }

    public static String getIdFromRouting(String routingId) {
        return UUID.nameUUIDFromBytes(("/RoutingIndex/" + routingId).getBytes()).toString();
    }

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }



}
