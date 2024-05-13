package com.retexspa.xr.ms.iam.main.core.dto.ruoliApplicazione;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuoliApplicazioneIndexDTO {

    private String ruoliApplicazioneId;
    private String applicazioneId;
    private String societaId;
    private LinkedList<String> attributiRuoloIds;

    private LinkedList<String> utentiApplicazioniIds;
    private LinkedList<String> ruoliRoutingIds;
    private LinkedList<String> ruoliNotificheIds;
    public RuoliApplicazioneIndexDTO() {
    }

    public RuoliApplicazioneIndexDTO(String ruoliApplicazioneId) {
        this.ruoliApplicazioneId = ruoliApplicazioneId;
    }

    public RuoliApplicazioneIndexDTO(String ruoliApplicazioneId, String applicazioniId, String societaId) {
        this.ruoliApplicazioneId = ruoliApplicazioneId;
        this.applicazioneId = applicazioniId;
        this.societaId = societaId;
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

    public LinkedList<String> getAttributiRuoloIds() {
        return attributiRuoloIds;
    }

    public void setAttributiRuoloIds(LinkedList<String> attributiRuoloIds) {
        this.attributiRuoloIds = attributiRuoloIds;
    }

    public LinkedList<String> getUtentiApplicazioniIds() {
        return utentiApplicazioniIds;
    }

    public void setUtentiApplicazioniIds(LinkedList<String> utentiApplicazioniIds) {
        this.utentiApplicazioniIds = utentiApplicazioniIds;
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
  
    public LinkedList<String> getRuoliRoutingIds() {
        return ruoliRoutingIds;
    }

    public void setRuoliRoutingIds(LinkedList<String> ruoliRoutingIds) {
        this.ruoliRoutingIds = ruoliRoutingIds;
    }
    public LinkedList<String> getRuoliNotificheIds() {
        return ruoliNotificheIds;
    }

    public void setRuoliNotificheIds(LinkedList<String> ruoliNotificheIds) {
        this.ruoliNotificheIds = ruoliNotificheIds;
    }


    
    
    

    public static String getDetailNameAttributiRuolo() {
        return "attributiRuoloIds";
      }

    public static String getDetailNameUtentiApplicazioni() {
        return "utentiApplicazioniIds";
      }

      public static String getDetailNameRuoliRouting() {
        return "ruoliRoutingIds";
      } 

      public static String getDetailNameRuoliNotifiche() {
        return "ruoliNotificheIds";
      } 

}
