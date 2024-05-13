package com.retexspa.xr.ms.iam.main.core.dto.attributiRuoli;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttributiRuoliIndexDTO {

    private String attributiRuoliId;


    public static String getIdFromAttributiRuoli(String attributiRuoliId) {
        return UUID.nameUUIDFromBytes(("/AttributiRuoliIndex/" + attributiRuoliId).getBytes()).toString();
    }

    public AttributiRuoliIndexDTO() {
    }

    public AttributiRuoliIndexDTO(String attributiRuoliId) {
        this.attributiRuoliId = attributiRuoliId;
    }



    public String getAttributiRuoliId() {
        return attributiRuoliId;
    }

    public void setAttributiRuoliId(String attributiRuoliId) {
        this.attributiRuoliId = attributiRuoliId;
    }


}


