package com.retexspa.xr.ms.iam.main.core.dto.anagAttributiUtenti;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnagAttributiUtentiIndexDTO {

    private String anagAttributiUtentiId;
    private String applicazioneId;
    private String societaId;
    private LinkedList<String> attributiUtenteIds;

    public AnagAttributiUtentiIndexDTO() {
    }

    public AnagAttributiUtentiIndexDTO(String anagAttributiUtentiId, String applicazioniId, String societaId) {
        this.anagAttributiUtentiId = anagAttributiUtentiId;
        this.applicazioneId = applicazioniId;
        this.societaId = societaId;
    }

    public static String getIdFromAnagAttributiUtenti(String anagAttributiUtentiId) {
        return UUID.nameUUIDFromBytes(("/AnagAttributiUtentiIndex/" + anagAttributiUtentiId).getBytes()).toString();
    }

    public String getAnagAttributiUtentiId() {
        return anagAttributiUtentiId;
    }

    public void setAnagAttributiUtentiId(String anagAttributiUtentiId) {
        this.anagAttributiUtentiId = anagAttributiUtentiId;
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

    public LinkedList<String> getAttributiUtenteIds() {
        return attributiUtenteIds;
    }

    public void setAttributiUtenteIds(LinkedList<String> attributiUtenteIds) {
        this.attributiUtenteIds = attributiUtenteIds;
    }

    
    public static String getDetailNameAttributiUtenti() {
        return "attributiUtentiIds";
    }
}
