package com.retexspa.xr.ms.iam.main.core.dto.applicazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicazioniIndexDTO {

  private String applicazioniId;
  private String societaId;
  private LinkedList<String> tipiContestoApplicazioneIds;
  private LinkedList<String> ruoliApplicazioneIds;
  private LinkedList<String> anagraficaAttributiRuoliIds;
  private LinkedList<String> anagraficaAttributiRuoliSharedIds;

  public ApplicazioniIndexDTO() {
  }

  public ApplicazioniIndexDTO(String applicazioniId) {
    this.applicazioniId = applicazioniId;
  }

  public ApplicazioniIndexDTO(String applicazioniId, String societaId) {
    this.applicazioniId = applicazioniId;
    this.societaId = societaId;
  }

  public static String getIdFromApplicazioni(String applicazioniId) {
    return UUID.nameUUIDFromBytes(("/ApplicazioniIndex/" + applicazioniId).getBytes()).toString();
  }

  public static String getDetailNameTipoContesto() {
    return "tipiContestoApplicazioneIds";
  }

  public String getApplicazioniId() {
    return this.applicazioniId;
  }

  public void setApplicazioniId(String applicazioniId) {
    this.applicazioniId = applicazioniId;
  }

  public LinkedList<String> getTipiContestoApplicazioneIds() {
    return tipiContestoApplicazioneIds;
  }

  public void setTipiContestoApplicazioneIds(LinkedList<String> tipiContestoApplicazioneIds) {
    this.tipiContestoApplicazioneIds = tipiContestoApplicazioneIds;
  }

  public LinkedList<String> getRuoliApplicazioneIds() {
    return ruoliApplicazioneIds;
  }

  public void setRuoliApplicazioneIds(LinkedList<String> ruoliApplicazioneIds) {
    this.ruoliApplicazioneIds = ruoliApplicazioneIds;
  }

  public LinkedList<String> getAnagraficaAttributiRuoliIds() {
    return anagraficaAttributiRuoliIds;
  }

  public void setAnagraficaAttributiRuoliIds(LinkedList<String> anagraficaAttributiRuoliIds) {
    this.anagraficaAttributiRuoliIds = anagraficaAttributiRuoliIds;
  }

  public LinkedList<String> getAnagraficaAttributiRuoliSharedIds() {
    return anagraficaAttributiRuoliSharedIds;
  }

  public void setAnagraficaAttributiRuoliSharedIds(LinkedList<String> anagraficaAttributiRuoliSharedIds) {
    this.anagraficaAttributiRuoliSharedIds = anagraficaAttributiRuoliSharedIds;
  }

  public String getSocietaId() {
    return societaId;
  }

  public void setSocietaId(String societaId) {
    this.societaId = societaId;
  }

  public static String getDetailNameTipiContestoApplicazione() {
    return "tipiContestoApplicazioneIds";
  }

  public static String getDetailNameRuoliApplicazione() {
    return "ruoliApplicazioneIds";
  }

  public static String getDetailNameAnagraficaAttributiRuoli() {
    return "anagraficaAttributiRuoliIds";
  }

  public static String getDetailNameAnagraficaAttributiRuoliShared() {
    return "anagraficaAttributiRuoliSharedIds";
  }

}
