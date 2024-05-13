package com.retexspa.xr.ms.iam.main.core.queries.routingSections;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoutingSectionsAggregateGetByIdQuery {
    private String routingSectionsId;

    public RoutingSectionsAggregateGetByIdQuery (@JsonProperty("routingSectionsId") String routingSectionsId) {
        this.routingSectionsId = routingSectionsId;
    }

    public String getRoutingSectionsId() {
        return routingSectionsId;
    }

    public void setRoutingSectionsId(String routingSectionsId) {
        this.routingSectionsId = routingSectionsId;
    }
}
