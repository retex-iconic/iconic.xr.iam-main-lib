package com.retexspa.xr.ms.iam.main.core.dto.tipiContestoApplicazione;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipiContestoApplicazioneIndexDTO {

  private String tipiContestoApplicazioneId;
  private String applicazioneId;
  private String societaId;
  private LinkedList<String> contestiApplicazioneIds;
  private LinkedList<String> anagAttributiUtentiIds;
  private LinkedList<String> attributiUtenteSharedIds;

  public TipiContestoApplicazioneIndexDTO() {
  }

  public TipiContestoApplicazioneIndexDTO(String tipiContestoApplicazioneId) {
    this.tipiContestoApplicazioneId = tipiContestoApplicazioneId;
  }

  public TipiContestoApplicazioneIndexDTO(String tipiContestoApplicazioneId, String applicazioniId, String societaId) {
    this.tipiContestoApplicazioneId = tipiContestoApplicazioneId;
    this.applicazioneId = applicazioniId;
    this.societaId = societaId;
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

  public LinkedList<String> getContestiApplicazioneIds() {
    return contestiApplicazioneIds;
  }

  public void setContestiApplicazioneIds(LinkedList<String> contestiApplicazioneIds) {
    this.contestiApplicazioneIds = contestiApplicazioneIds;
  }

  public LinkedList<String> getAnagAttributiUtentiIds() {
    return anagAttributiUtentiIds;
  }

  public void setAnagAttributiUtentiIds(LinkedList<String> anagAttributiUtentiIds) {
    this.anagAttributiUtentiIds = anagAttributiUtentiIds;
  }

  public LinkedList<String> getAttributiUtenteSharedIds() {
    return attributiUtenteSharedIds;
  }

  public void setAttributiUtenteSharedIds(LinkedList<String> attributiUtenteSharedIds) {
    this.attributiUtenteSharedIds = attributiUtenteSharedIds;
  }

  public String getApplicazioneId() {
    return applicazioneId;
  }

  public void setApplicazioneId(String applicazioneId) {
    this.applicazioneId = applicazioneId;
  }

  public String getSocietaId() {
    return societaId;
  }

  public void setSocietaId(String societaId) {
    this.societaId = societaId;

  }

  public static String getDetailNameContestiApplicazione() {
    return "contestiApplicazioneIds";
  }

  public static String getDetailNameAnagAttributiUtenti() {
    return "anagAttributiUtentiIds";
  }

  public static String getDetailNameAttributiUtenteShared() {
    return "attributiUtenteSharedIds";
  }

}
