package com.retexspa.xr.ms.iam.main.core.dto.ruoliNotifiche;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuoliNotificheIndexDTO {
    private String ruoliNotifiche;

    public RuoliNotificheIndexDTO() {
    }

    public RuoliNotificheIndexDTO(String ruoliNotifiche) {
        this.ruoliNotifiche = ruoliNotifiche;
    }

    public static String getIdFromRuoliNotifiche(String ruoliNotificheId) {
        return UUID.nameUUIDFromBytes(("/RuoliNotificheIndex/" + ruoliNotificheId).getBytes()).toString();
    }

    public String getRuoliNotifiche() {
        return ruoliNotifiche;
    }

    public void setRuoliNotifiche(String ruoliNotifiche) {
        this.ruoliNotifiche = ruoliNotifiche;
    }

}
