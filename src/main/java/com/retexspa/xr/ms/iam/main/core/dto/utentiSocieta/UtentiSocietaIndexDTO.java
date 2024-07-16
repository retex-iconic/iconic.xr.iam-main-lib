package com.retexspa.xr.ms.iam.main.core.dto.utentiSocieta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtentiSocietaIndexDTO {

    private String utentiSocietaId;
    private String societaId;
    private String badgeId;
    private LinkedList<String> utentiApplicazioniIds;
    private LinkedList<String> sostituzioneBadgeIds;
    private LinkedList<String> sostituzioneBadgeStoricoPersonaleIds;


    public UtentiSocietaIndexDTO() {
    }

    public UtentiSocietaIndexDTO(String utentiSocietaId, String societaId, String badgeId) {
        this.utentiSocietaId = utentiSocietaId;
        this.societaId = societaId;
        this.badgeId = badgeId;
    }

    public static String getIdFromUtentiSocieta(String utentiSocietaId) {
        return UUID.nameUUIDFromBytes(("/UtentiSocietaIndex/" + utentiSocietaId).getBytes()).toString();
    }

    public String getUtentiSocietaId() {
        return utentiSocietaId;
    }

    public void setUtentiSocietaId(String utentiSocietaId) {
        this.utentiSocietaId = utentiSocietaId;
    }

    public LinkedList<String> getUtentiApplicazioniIds() {
        return utentiApplicazioniIds;
    }

    public LinkedList<String> getSostituzioneBadgeStoricoPersonaleIds() {
        return sostituzioneBadgeStoricoPersonaleIds;
    }

    public void setSostituzioneBadgeStoricoPersonaleIds(LinkedList<String> sostituzioneBadgeStoricoPersonaleIds) {
        this.sostituzioneBadgeStoricoPersonaleIds = sostituzioneBadgeStoricoPersonaleIds;
    }

    public void setUtentiApplicazioniIds(LinkedList<String> utentiApplicazioniIds) {
        this.utentiApplicazioniIds = utentiApplicazioniIds;
    }

    public LinkedList<String> getSostituzioneBadgeIds() {
        return sostituzioneBadgeIds;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(String badgeId) {
        this.badgeId = badgeId;
    }

    public void setSostituzioneBadgeIds(LinkedList<String> sostituzioneBadgeIds) {
        this.sostituzioneBadgeIds = sostituzioneBadgeIds;
    }

    public String getSocietaId() {
        return societaId;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
    }

    public static String getDetailNameUtentiApplicazioni() {
        return "utentiApplicazioniIds";
    }

    public static String getDetailNameSostituzioniBadge() {
        return "sostituzioneBadgeIds";
    }

    public static String getDetailNameSostituzioneBadgeStoricoPersonaleIds() {
        return "sostituzioneBadgeStoricoPersonaleIds";
    }

}
