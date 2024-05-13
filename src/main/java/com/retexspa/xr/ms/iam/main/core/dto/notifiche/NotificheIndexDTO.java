package com.retexspa.xr.ms.iam.main.core.dto.notifiche;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificheIndexDTO {
    private String notificheId;
    private LinkedList<String> ruoliNotificheIds;

    public NotificheIndexDTO() {
    }

    public NotificheIndexDTO(String notificheId) {
        this.notificheId = notificheId;
    }

    public static String getIdFromNotifiche(String notificheId) {
        return UUID.nameUUIDFromBytes(("/NotificheIndex/" + notificheId).getBytes()).toString();
    }

    public String getNotificheId() {
        return notificheId;
    }

    public void setNotificheId(String notificheId) {
        this.notificheId = notificheId;
    }

    public LinkedList<String> getRuoliNotificheIds() {
        return ruoliNotificheIds;
    }

    public void setRuoliNotificheIds(LinkedList<String> ruoliNotificheIds) {
        this.ruoliNotificheIds = ruoliNotificheIds;
    }

    public static String getDetailNameRuoliNotifiche() {
        return "ruoliNotificheIds";
    }

}
