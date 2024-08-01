package com.retexspa.xr.ms.iam.main.core.dto.utenti;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtentiIndexDTO {

    private String utentiId;


    public UtentiIndexDTO() {
    }

    public UtentiIndexDTO(String utentiId) {
        this.utentiId = utentiId;
    }

    public static String getIdFromUtenti(String utentiId) {
        return UUID.nameUUIDFromBytes(("/UtentiIndex/" + utentiId).getBytes()).toString();
    }

    public String getUtentiId() {
        return utentiId;
    }

    public void setUtentiId(String utentiId) {
        this.utentiId = utentiId;
    }


}
