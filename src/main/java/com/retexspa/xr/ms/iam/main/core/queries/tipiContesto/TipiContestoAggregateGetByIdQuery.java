package com.retexspa.xr.ms.iam.main.core.queries.tipiContesto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipiContestoAggregateGetByIdQuery {
    private String tipiContestoId;

    public TipiContestoAggregateGetByIdQuery(@JsonProperty("tipiContestoId") String tipiContestoId) {
        this.tipiContestoId = tipiContestoId;
    }

    public String getTipiContestoId() {
        return tipiContestoId;
    }

    public void setTipiContestoId(String tipiContestoId) {
        this.tipiContestoId = tipiContestoId;
    }
}
