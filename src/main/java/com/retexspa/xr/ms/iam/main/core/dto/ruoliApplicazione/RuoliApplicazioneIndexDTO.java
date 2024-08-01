package com.retexspa.xr.ms.iam.main.core.dto.ruoliApplicazione;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuoliApplicazioneIndexDTO {

    private String ruoliApplicazioneId;
    public RuoliApplicazioneIndexDTO() {
    }

    public RuoliApplicazioneIndexDTO(String ruoliApplicazioneId) {
        this.ruoliApplicazioneId = ruoliApplicazioneId;
    }

    public static String getIdFromRuoliApplicazione(String ruoliApplicazioneId) {
        return UUID.nameUUIDFromBytes(("/RuoliApplicazioneIndex/" + ruoliApplicazioneId).getBytes()).toString();
    }

    public String getRuoliApplicazioneId() {
        return ruoliApplicazioneId;
    }

    public void setRuoliApplicazioneId(String ruoliApplicazioneId) {
        this.ruoliApplicazioneId = ruoliApplicazioneId;
    }
  
}
