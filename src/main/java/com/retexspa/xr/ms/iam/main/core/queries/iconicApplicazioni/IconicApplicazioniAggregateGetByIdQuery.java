package com.retexspa.xr.ms.iam.main.core.queries.iconicApplicazioni;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IconicApplicazioniAggregateGetByIdQuery {
    private String iconicApplicazioniId;

    public IconicApplicazioniAggregateGetByIdQuery(@JsonProperty("iconicApplicazioniId") String iconicApplicazioniId) {
        this.iconicApplicazioniId = iconicApplicazioniId;
    }

    public String getIconicApplicazioniId() {
        return iconicApplicazioniId;
    }

    public void setIconicApplicazioniId(String iconicApplicazioniId) {
        this.iconicApplicazioniId = iconicApplicazioniId;
    }
}
