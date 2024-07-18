package com.retexspa.xr.ms.iam.main.core.dto.badgeSocieta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BadgeSocietaIndexDTO {

    private String badgeSocietaId;
    private String societaId;
    @EnumValidator(enumClazz = Enums.TipoBadge.class)
    private String tipoBadge;
    private LinkedList<String> utentiSocietaIds;
    private LinkedList<String> sostituzioniBadgeIds;

    public static String getIdFromBadgeSocieta(String badgeSocietaId) {
        return UUID.nameUUIDFromBytes(("/BadgeSocietaIndex/" + badgeSocietaId).getBytes()).toString();
    }

    public BadgeSocietaIndexDTO() {
    }

    public BadgeSocietaIndexDTO(String badgeSocietaId, String societaId, String tipoBadge) {
        this.badgeSocietaId = badgeSocietaId;
        this.societaId = societaId;
        this.tipoBadge = tipoBadge;
    }

    public String getBadgeSocietaId() {
        return badgeSocietaId;
    }

    public void setBadgeSocietaId(String badgeSocietaId) {
        this.badgeSocietaId = badgeSocietaId;
    }

    public LinkedList<String> getSostituzioniBadgeIds() {
        return sostituzioniBadgeIds;
    }

    public void setSostituzioniBadgeIds(LinkedList<String> sostituzioniBadgeIds) {
        this.sostituzioniBadgeIds = sostituzioniBadgeIds;
    }

    public String getSocietaId() {
        return societaId;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
    }


    public static String getDetailNameSostituzioneBadge() {
        return "sostituzioneBadgeIds";
    }

    public static String getDetailNameUtentiSocieta() {
        return "utentiSocietaIds";
    }

    public LinkedList<String> getUtentiSocietaIds() {
        return utentiSocietaIds;
    }

    public void setUtentiSocietaIds(LinkedList<String> utentiSocietaIds) {
        this.utentiSocietaIds = utentiSocietaIds;
    }

    public String getTipoBadge() {
        return tipoBadge;
    }

    public void setTipoBadge(String tipoBadge) {
        this.tipoBadge = tipoBadge;
    }

}
