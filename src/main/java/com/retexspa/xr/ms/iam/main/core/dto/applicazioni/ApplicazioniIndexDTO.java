package com.retexspa.xr.ms.iam.main.core.dto.applicazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicazioniIndexDTO {

  private String applicazioniId;

  public ApplicazioniIndexDTO() {
  }

  public ApplicazioniIndexDTO(String applicazioniId) {
    this.applicazioniId = applicazioniId;
  }

  public static String getIdFromApplicazioni(String applicazioniId) {
    return UUID.nameUUIDFromBytes(("/ApplicazioniIndex/" + applicazioniId).getBytes()).toString();
  }

  public String getApplicazioniId() {
    return this.applicazioniId;
  }

  public void setApplicazioniId(String applicazioniId) {
    this.applicazioniId = applicazioniId;
  }
}
