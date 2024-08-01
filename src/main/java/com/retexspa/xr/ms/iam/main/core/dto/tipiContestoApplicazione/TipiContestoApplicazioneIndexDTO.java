package com.retexspa.xr.ms.iam.main.core.dto.tipiContestoApplicazione;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipiContestoApplicazioneIndexDTO {

  private String tipiContestoApplicazioneId;

  public TipiContestoApplicazioneIndexDTO() {
  }

  public TipiContestoApplicazioneIndexDTO(String tipiContestoApplicazioneId) {
    this.tipiContestoApplicazioneId = tipiContestoApplicazioneId;
  }

  public static String getIdFromTipiContestoApplicazione(String tipiContestoApplicazioneId) {
    return UUID.nameUUIDFromBytes(("/TipiContestoApplicazioneIndex/" + tipiContestoApplicazioneId).getBytes()).toString();
  }

  public String getTipiContestoApplicazioneId() {
    return tipiContestoApplicazioneId;
  }

  public void setTipiContestoApplicazioneId(String tipiContestoApplicazioneId) {
    this.tipiContestoApplicazioneId = tipiContestoApplicazioneId;
  }


}
