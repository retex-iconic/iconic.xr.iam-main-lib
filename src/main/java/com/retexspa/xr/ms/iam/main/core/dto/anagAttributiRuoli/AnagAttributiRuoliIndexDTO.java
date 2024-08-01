package com.retexspa.xr.ms.iam.main.core.dto.anagAttributiRuoli;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnagAttributiRuoliIndexDTO {

    private String anagAttributiRuoliId;

    public static String getIdFromAnagAttributiRuoli(String anagAttributiRuoliId) {
        return UUID.nameUUIDFromBytes(("/AnagAttributiRuoliIndex/" + anagAttributiRuoliId).getBytes()).toString();
    }

    public AnagAttributiRuoliIndexDTO() {
    }

    public AnagAttributiRuoliIndexDTO(String anagAttributiRuoliId) {
        this.anagAttributiRuoliId = anagAttributiRuoliId;
       
    }

    public String getAnagAttributiRuoliId() {
        return anagAttributiRuoliId;
    }

    public void setAnagAttributiRuoliId(String anagAttributiRuoliId) {
        this.anagAttributiRuoliId = anagAttributiRuoliId;
    }    

}
