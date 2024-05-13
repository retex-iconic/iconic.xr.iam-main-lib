package com.retexspa.xr.ms.iam.main.core.queries.ruoliRoutingSections;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RuoliRoutingSectionsAggregateGetByIdQuery {
    private String ruoliRoutingSectionsId;

    public RuoliRoutingSectionsAggregateGetByIdQuery (@JsonProperty("ruoliRoutingSectionsId") String ruoliRoutingSectionsId) {
        this.ruoliRoutingSectionsId = ruoliRoutingSectionsId;
    }

    public String getRuoliRoutingSectionsId() {
        return ruoliRoutingSectionsId;
    }

    public void setRuoliRoutingSectionsId(String ruoliRoutingSectionsId) {
        this.ruoliRoutingSectionsId = ruoliRoutingSectionsId;
    }
}
