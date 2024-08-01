package com.retexspa.xr.ms.iam.main.core.dto.badgeSocieta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BadgeSocietaIndexDTO {

    private String badgeSocietaId;

    public static String getIdFromBadgeSocieta(String badgeSocietaId) {
        return UUID.nameUUIDFromBytes(("/BadgeSocietaIndex/" + badgeSocietaId).getBytes()).toString();
    }

    public BadgeSocietaIndexDTO() {
    }

    public BadgeSocietaIndexDTO(String badgeSocietaId) {
        this.badgeSocietaId = badgeSocietaId;
    }

    public String getBadgeSocietaId() {
        return badgeSocietaId;
    }

    public void setBadgeSocietaId(String badgeSocietaId) {
        this.badgeSocietaId = badgeSocietaId;
    }

}
