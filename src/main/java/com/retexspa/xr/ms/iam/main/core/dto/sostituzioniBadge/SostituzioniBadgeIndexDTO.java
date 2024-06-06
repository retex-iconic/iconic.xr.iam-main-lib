package com.retexspa.xr.ms.iam.main.core.dto.sostituzioniBadge;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SostituzioniBadgeIndexDTO {
    private String sostituzioniBadgeId;

    private String societaId;

    public SostituzioniBadgeIndexDTO() {
    }

    public void setSostituzioniBadgeId(String sostituzioniBadgeId) {
        this.sostituzioniBadgeId = sostituzioniBadgeId;
    }

    public SostituzioniBadgeIndexDTO(String sostituzioniBadgeId, String societaId) {
        this.sostituzioniBadgeId = sostituzioniBadgeId;
        this.societaId = societaId;
    }

    public static String getIdFromSostituzioniBadge(String sostituzioniBadgeId) {
        return UUID.nameUUIDFromBytes(("/SostituzioniBadgeIndex/" + sostituzioniBadgeId).getBytes()).toString();
    }

    public String getSostituzioniBadgeId() {
        return sostituzioniBadgeId;
    }

    public String getSocietaId() {
        return societaId;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
    }

}
