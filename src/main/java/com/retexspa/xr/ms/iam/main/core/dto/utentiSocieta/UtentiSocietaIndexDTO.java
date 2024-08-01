package com.retexspa.xr.ms.iam.main.core.dto.utentiSocieta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtentiSocietaIndexDTO {

    private String utentiSocietaId;


    public UtentiSocietaIndexDTO() {
    }

    public UtentiSocietaIndexDTO(String utentiSocietaId) {
        this.utentiSocietaId = utentiSocietaId;
    }

    public static String getIdFromUtentiSocieta(String utentiSocietaId) {
        return UUID.nameUUIDFromBytes(("/UtentiSocietaIndex/" + utentiSocietaId).getBytes()).toString();
    }

    public String getUtentiSocietaId() {
        return utentiSocietaId;
    }

    public void setUtentiSocietaId(String utentiSocietaId) {
        this.utentiSocietaId = utentiSocietaId;
    }

}
