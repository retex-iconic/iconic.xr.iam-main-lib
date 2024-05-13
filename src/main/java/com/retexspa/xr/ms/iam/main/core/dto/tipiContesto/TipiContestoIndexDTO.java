package com.retexspa.xr.ms.iam.main.core.dto.tipiContesto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipiContestoIndexDTO {

  private String tipiContestoId;
  private LinkedList<String> tipiContestoApplicazioneIds;

  public TipiContestoIndexDTO() {
  }

  public TipiContestoIndexDTO(String tipiContestoId) {
    this.tipiContestoId = tipiContestoId;
  }  
  
  public static String getIdFromTipiContesto(String tipiContestoId) {
    return UUID.nameUUIDFromBytes(("/TipiContestoIndex/" + tipiContestoId).getBytes()).toString();
  }

  public String getTipiContestoId() {
    return tipiContestoId;
  }

  public void setTipiContestoId(String tipiContestoId) {
    this.tipiContestoId = tipiContestoId;
  }

  public LinkedList<String> getTipiContestoApplicazioneIds() {
    return tipiContestoApplicazioneIds;
  }

  public void setTipiContestoApplicazioneIds(LinkedList<String> tipiContestoApplicazioneIds) {
    this.tipiContestoApplicazioneIds = tipiContestoApplicazioneIds;
  }

  public static String getDetailNameTipiContestoApplicazione() {
    return "tipiContestoApplicazioneIds";
  }

}
