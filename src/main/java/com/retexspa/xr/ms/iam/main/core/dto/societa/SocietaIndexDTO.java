package com.retexspa.xr.ms.iam.main.core.dto.societa;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class SocietaIndexDTO {

  private String societaId;
  private LinkedList<String> utentiSocietaIds;
  private LinkedList<String> applicazioniIds;
  private LinkedList<String> badgeSocietaIds;

  public SocietaIndexDTO() {
  }

  public SocietaIndexDTO(String societaId) {
    this.societaId = societaId;
  }

  public static String getIdFromSocieta(String societaId) {
    return UUID.nameUUIDFromBytes(("/SocietaIndex/" + societaId).getBytes()).toString();
  }

  public String getSocietaId() {
    return this.societaId;
  }

  public void setSocietaId(String societaId) {
    this.societaId = societaId;
  }

  public LinkedList<String> getUtentiSocietaIds() {
    return utentiSocietaIds;
  }

  public void setUtentiSocietaIds(LinkedList<String> utentiSocietaIds) {
    this.utentiSocietaIds = utentiSocietaIds;
  }

  public LinkedList<String> getApplicazioniIds() {
    return applicazioniIds;
  }

  public void setApplicazioniIds(LinkedList<String> applicazioniIds) {
    this.applicazioniIds = applicazioniIds;
  }

  public LinkedList<String> getBadgeSocietaIds() {
    return badgeSocietaIds;
  }

  public void setBadgeSocietaIds(LinkedList<String> badgeSocietaIds) {
    this.badgeSocietaIds = badgeSocietaIds;
  }

  public static String getDetailNameUtentiSocieta(){
    return "utentiSocietaIds";
  }
  public static String getDetailNameApplicazioni(){
    return "applicazioniIds";
  }
  public static String getDetailNameBadgeSocieta() {
    return "badgeSocietaIds";
  }

}
