package com.retexspa.xr.ms.iam.main.core.queries.tipiContesto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipiContestoAggregateGetEventsByIdQuery {
    private String tipiContestoId;

    public TipiContestoAggregateGetEventsByIdQuery(@JsonProperty("tipiContestoId") String tipiContestoId) {
        this.tipiContestoId = tipiContestoId;
    }

    public String getTipiContestoId() {
        return tipiContestoId;
    }

    public void setTipiContestoId(String tipiContestoId) {
        this.tipiContestoId = tipiContestoId;
    }
}
