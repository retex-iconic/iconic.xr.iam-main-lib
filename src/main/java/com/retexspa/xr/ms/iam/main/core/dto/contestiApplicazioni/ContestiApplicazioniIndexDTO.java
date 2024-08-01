package com.retexspa.xr.ms.iam.main.core.dto.contestiApplicazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContestiApplicazioniIndexDTO {

    private String contestiApplicazioniId;

    public ContestiApplicazioniIndexDTO() {
    }

    public ContestiApplicazioniIndexDTO(String contestiApplicazioniId) {
        this.contestiApplicazioniId = contestiApplicazioniId;
    }

    public static String getIdFromContestiApplicazioni(String contestiApplicazioniId) {
        return UUID.nameUUIDFromBytes(("/ContestiApplicazioniIndex/" + contestiApplicazioniId).getBytes()).toString();
    }

    public String getContestiApplicazioniId() {
        return contestiApplicazioniId;
    }

    public void setContestiApplicazioniId(String contestiApplicazioniId) {
        this.contestiApplicazioniId = contestiApplicazioniId;
    }
}
