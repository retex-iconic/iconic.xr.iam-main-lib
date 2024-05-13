package com.retexspa.xr.ms.iam.main.core.queries.notifiche;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificheAggregateGetEventsByIdQuery {
    private String notificheId;

    public NotificheAggregateGetEventsByIdQuery(@JsonProperty("notificheId") String notificheId) {
        this.notificheId = notificheId;
    }

    public String getNotificheId() {
        return notificheId;
    }

    public void setNotificheId(String notificheId) {
        this.notificheId = notificheId;
    }
}
