package com.retexspa.xr.ms.iam.main.core.dto.utentiApplicazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtentiApplicazioniIndexDTO {

    private String utentiApplicazioniId;
    private String applicazioneId;
    private String societaId;
    private LinkedList<String> attributiUtentiIds;

    public static String getIdFromUtentiApplicazioni(String utentiApplicazioniId) {
        return UUID.nameUUIDFromBytes(("/UtentiApplicazioniIndex/" + utentiApplicazioniId).getBytes()).toString();
    }

    public UtentiApplicazioniIndexDTO() {
    }

    public UtentiApplicazioniIndexDTO(String utentiApplicazioniId, String applicazioneId, String societaId) {

        this.utentiApplicazioniId = utentiApplicazioniId;
        this.applicazioneId = applicazioneId;
        this.societaId = societaId;
    }

    public String getUtentiApplicazioniId() {
        return utentiApplicazioniId;
    }

    public void setUtentiApplicazioniId(String utentiApplicazioniId) {
        this.utentiApplicazioniId = utentiApplicazioniId;
    }

    public LinkedList<String> getAttributiUtentiIds() {
        return attributiUtentiIds;
    }

    public void setAttributiUtentiIds(LinkedList<String> attributiUtentiIds) {
        this.attributiUtentiIds = attributiUtentiIds;
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

    public static String getDetailNameAttributiUtenti() {
        return "attributiUtentiIds";
    }
}
