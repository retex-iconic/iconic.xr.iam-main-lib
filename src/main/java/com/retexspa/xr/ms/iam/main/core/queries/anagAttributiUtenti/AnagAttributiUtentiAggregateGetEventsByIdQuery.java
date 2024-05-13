package com.retexspa.xr.ms.iam.main.core.queries.anagAttributiUtenti;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnagAttributiUtentiAggregateGetEventsByIdQuery {
    private String anagAttributiUtentiId;

    public AnagAttributiUtentiAggregateGetEventsByIdQuery(@JsonProperty("anagAttributiUtentiId") String anagAttributiUtentiId) {
        this.anagAttributiUtentiId = anagAttributiUtentiId;
    }

    public String getAnagAttributiUtentiId() {
        return anagAttributiUtentiId;
    }

    public void setAnagAttributiUtentiId(String anagAttributiUtentiId) {
        this.anagAttributiUtentiId = anagAttributiUtentiId;
    }
}
