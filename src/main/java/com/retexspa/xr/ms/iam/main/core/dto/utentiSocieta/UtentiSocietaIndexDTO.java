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
    private LinkedList<String> utentiApplicazioniIds;
    private LinkedList<String> sostituzioneBadgeIds;

    public UtentiSocietaIndexDTO() {
    }

    public UtentiSocietaIndexDTO(String utentiSocietaId, String societaId) {
        this.utentiSocietaId = utentiSocietaId;
        this.societaId = societaId;
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

    public void setUtentiApplicazioniIds(LinkedList<String> utentiApplicazioniIds) {
        this.utentiApplicazioniIds = utentiApplicazioniIds;
    }

    public LinkedList<String> getSostituzioneBadgeIds() {
        return sostituzioneBadgeIds;
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

}
