package com.retexspa.xr.ms.iam.main.core.dto.iconicApplicazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IconicApplicazioniIndexDTO {

  private String iconicApplicazioniId;
  private LinkedList<String> applicazioniIds;
  private LinkedList<String> routingIds;

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

  public LinkedList<String> getApplicazioniIds() {
    return applicazioniIds;
  }

  public void setApplicazioniIds(LinkedList<String> tipiContestoApplicazioneIds) {
    this.applicazioniIds = tipiContestoApplicazioneIds;
  }

  public LinkedList<String> getRoutingIds() {
    return routingIds;
  }

  public void setRoutingIds(LinkedList<String> routingIds) {
    this.routingIds = routingIds;
  }

  public static String getDetailNameApplicazioni() {
    return "applicazioniIds";
  }

  public static String getDetailNameRouting() {
    return "routingIds";
  }

}
