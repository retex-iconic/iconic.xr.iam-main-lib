package com.retexspa.xr.ms.iam.main.core.queries.attributiRuoli;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributiRuoliAggregateGetByIdQuery {
    private String attributiRuoliId;

    public AttributiRuoliAggregateGetByIdQuery(@JsonProperty("attributiRuoliId") String attributiRuoliId) {
        this.attributiRuoliId = attributiRuoliId;
    }

    public String getAttributiRuoliId() {
        return attributiRuoliId;
    }

    public void setAttributiRuoliId(String attributiRuoliId) {
        this.attributiRuoliId = attributiRuoliId;
    }
}
