package com.retexspa.xr.ms.iam.main.core.queries.attributiUtenti;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributiUtentiAggregateGetByIdQuery {

    private String attributiUtentiId;

    public AttributiUtentiAggregateGetByIdQuery(@JsonProperty("attributiUtentiId") String attributiUtentiId) {
        this.attributiUtentiId = attributiUtentiId;
    }

    public String getAttributiUtentiId() {
        return attributiUtentiId;
    }

    public void setAttributiUtentiId(String attributiUtentiId) {
        this.attributiUtentiId = attributiUtentiId;
    }
}
