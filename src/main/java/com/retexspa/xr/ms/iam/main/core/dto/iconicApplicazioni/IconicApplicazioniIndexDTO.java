package com.retexspa.xr.ms.iam.main.core.dto.iconicApplicazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IconicApplicazioniIndexDTO {

  private String iconicApplicazioniId;

  public IconicApplicazioniIndexDTO() {
  }

  public IconicApplicazioniIndexDTO(String iconicApplicazioniId) {
    this.iconicApplicazioniId = iconicApplicazioniId;
  }

  public static String getIdFromIconicApplicazioni(String iconicApplicazioniId) {
    return UUID.nameUUIDFromBytes(("/IconicApplicazioniIndex/" + iconicApplicazioniId).getBytes()).toString();
  }

  public String getIconicApplicazioniId() {
    return this.iconicApplicazioniId;
  }

  public void setIconicApplicazioniId(String applicazioniId) {
    this.iconicApplicazioniId = applicazioniId;
  }

}
