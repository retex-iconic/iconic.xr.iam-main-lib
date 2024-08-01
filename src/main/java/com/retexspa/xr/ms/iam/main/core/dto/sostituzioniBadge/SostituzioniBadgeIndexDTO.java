package com.retexspa.xr.ms.iam.main.core.dto.sostituzioniBadge;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SostituzioniBadgeIndexDTO {
    private String sostituzioniBadgeId;

    public SostituzioniBadgeIndexDTO() {
    }

    public void setSostituzioniBadgeId(String sostituzioniBadgeId) {
        this.sostituzioniBadgeId = sostituzioniBadgeId;
    }

    public static String getIdFromSostituzioniBadge(String sostituzioniBadgeId) {
        return UUID.nameUUIDFromBytes(("/SostituzioniBadgeIndex/" + sostituzioniBadgeId).getBytes()).toString();
    }

    public String getSostituzioniBadgeId() {
        return sostituzioniBadgeId;
    }
}
