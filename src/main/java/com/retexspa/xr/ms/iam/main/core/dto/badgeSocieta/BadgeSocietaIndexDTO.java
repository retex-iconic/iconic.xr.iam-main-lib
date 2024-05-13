package com.retexspa.xr.ms.iam.main.core.dto.badgeSocieta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BadgeSocietaIndexDTO {

    private String badgeSocietaId;
    private String societaId;
    private LinkedList<String> sostituzioniBadgeIds;

    public static String getIdFromBadgeSocieta(String badgeSocietaId) {
        return UUID.nameUUIDFromBytes(("/BadgeSocietaIndex/" + badgeSocietaId).getBytes()).toString();
    }

    public BadgeSocietaIndexDTO() {
    }

    public BadgeSocietaIndexDTO(String badgeSocietaId, String societaId) {
        this.badgeSocietaId = badgeSocietaId;
        this.societaId = societaId;
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

}
