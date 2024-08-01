package com.retexspa.xr.ms.iam.main.core.dto.utentiApplicazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtentiApplicazioniIndexDTO {

    private String utentiApplicazioniId;

    public static String getIdFromUtentiApplicazioni(String utentiApplicazioniId) {
        return UUID.nameUUIDFromBytes(("/UtentiApplicazioniIndex/" + utentiApplicazioniId).getBytes()).toString();
    }

    public UtentiApplicazioniIndexDTO() {
    }

    public UtentiApplicazioniIndexDTO(String utentiApplicazioniId) {

        this.utentiApplicazioniId = utentiApplicazioniId;
    }

    public String getUtentiApplicazioniId() {
        return utentiApplicazioniId;
    }

    public void setUtentiApplicazioniId(String utentiApplicazioniId) {
        this.utentiApplicazioniId = utentiApplicazioniId;
    }

}
