package com.retexspa.xr.ms.iam.main.core.queries.ruoliNotifiche;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RuoliNotificheAggregateGetEventsByIdQuery {
    private String ruoliNotificheId;

    public RuoliNotificheAggregateGetEventsByIdQuery(@JsonProperty("ruoliNotificheId") String ruoliNotificheId) {
        this.ruoliNotificheId = ruoliNotificheId;
    }

    public String getRuoliNotificheId() {
        return ruoliNotificheId;
    }

    public void setRuoliNotificheId(String ruoliNotificheId) {
        this.ruoliNotificheId = ruoliNotificheId;
    }
}
