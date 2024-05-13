package com.retexspa.xr.ms.iam.main.core.queries.anagAttributiRuoli;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnagAttributiRuoliAggregateGetByIdQuery {
    private String anagAttributiRuoliId;

    public AnagAttributiRuoliAggregateGetByIdQuery(@JsonProperty("anagAttributiRuoliId") String anagAttributiRuoliId) {
        this.anagAttributiRuoliId = anagAttributiRuoliId;
    }

    public String getAnagAttributiRuoliId() {
        return anagAttributiRuoliId;
    }

    public void setAnagAttributiRuoliId(String anagAttributiRuoliId) {
        this.anagAttributiRuoliId = anagAttributiRuoliId;
    }
}
