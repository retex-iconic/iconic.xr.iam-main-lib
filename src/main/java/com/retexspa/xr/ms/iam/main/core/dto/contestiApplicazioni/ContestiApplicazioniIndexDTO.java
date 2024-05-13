package com.retexspa.xr.ms.iam.main.core.dto.contestiApplicazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContestiApplicazioniIndexDTO {

    private String contestiApplicazioniId;

    private String applicazioneId;
    private String societaId;
    private LinkedList<String> utentiApplicazioneIds;
    private LinkedList<String> attributiUtenteIds;

    public ContestiApplicazioniIndexDTO() {
    }

    public ContestiApplicazioniIndexDTO(String contestiApplicazioniId) {
        this.contestiApplicazioniId = contestiApplicazioniId;
    }

    public ContestiApplicazioniIndexDTO(String contestiApplicazioniId, String applicazioniId, String societaId) {
        this.contestiApplicazioniId = contestiApplicazioniId;
        this.applicazioneId = applicazioniId;
        this.societaId = societaId;
    }

    public static String getIdFromContestiApplicazioni(String contestiApplicazioniId) {
        return UUID.nameUUIDFromBytes(("/ContestiApplicazioniIndex/" + contestiApplicazioniId).getBytes()).toString();
    }

    public String getContestiApplicazioniId() {
        return contestiApplicazioniId;
    }

    public void setContestiApplicazioniId(String contestiApplicazioniId) {
        this.contestiApplicazioniId = contestiApplicazioniId;
    }

    public LinkedList<String> getUtentiApplicazioneIds() {
        return utentiApplicazioneIds;
    }

    public void setUtentiApplicazioneIds(LinkedList<String> utentiApplicazioneIds) {
        this.utentiApplicazioneIds = utentiApplicazioneIds;
    }

    public LinkedList<String> getAttributiUtenteIds() {
        return attributiUtenteIds;
    }

    public void setAttributiUtenteIds(LinkedList<String> attributiUtenteIds) {
        this.attributiUtenteIds = attributiUtenteIds;
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

    public static String getDetailNameUtentiApplicazione() {
        return "utentiApplicazioneIds";
    }

    public static String getDetailNameAttributiUtente() {
        return "attributiUtenteIds";
    }
}
