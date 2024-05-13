package com.retexspa.xr.ms.iam.main.core.dto.anagAttributiRuoli;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnagAttributiRuoliIndexDTO {

    private String anagAttributiRuoliId;

    private String applicazioneId;
    private String societaId;

    private LinkedList<String> attributiRuoloIds;

    public static String getIdFromAnagAttributiRuoli(String anagAttributiRuoliId) {
        return UUID.nameUUIDFromBytes(("/AnagAttributiRuoliIndex/" + anagAttributiRuoliId).getBytes()).toString();
    }

    public AnagAttributiRuoliIndexDTO() {
    }


    public AnagAttributiRuoliIndexDTO(String anagAttributiRuoliId, String applicazioneId, String societaId) {
        this.anagAttributiRuoliId = anagAttributiRuoliId;
        this.applicazioneId = applicazioneId;
        this.societaId = societaId;
    }

    public LinkedList<String> getAttributiRuoloIds() {
        return attributiRuoloIds;
    }

    public void setAttributiRuoloIds(LinkedList<String> attributiRuoloIds) {
        this.attributiRuoloIds = attributiRuoloIds;
    }

    public String getAnagAttributiRuoliId() {
        return anagAttributiRuoliId;
    }

    public void setAnagAttributiRuoliId(String anagAttributiRuoliId) {
        this.anagAttributiRuoliId = anagAttributiRuoliId;
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

    
    public static String getDetailNameAttributiRuolo() {
        return "attributiRuoloIds";
      }
    

}
