package com.retexspa.xr.ms.iam.main.core.queries.anagAttributiRuoli;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnagAttributiRuoliAggregateGetEventsByIdQuery {

    private String anagAttributiRuoliId;

    public AnagAttributiRuoliAggregateGetEventsByIdQuery(@JsonProperty("anagAttributiRuoliId") String anagAttributiRuoliId) {
        this.anagAttributiRuoliId = anagAttributiRuoliId;
    }

    public String getAnagAttributiRuoliId() {
        return anagAttributiRuoliId;
    }

    public void setAnagAttributiRuoliId(String anagAttributiRuoliId) {
        this.anagAttributiRuoliId = anagAttributiRuoliId;
    }
}
