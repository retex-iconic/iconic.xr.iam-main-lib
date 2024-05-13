package com.retexspa.xr.ms.iam.main.core.dto.configUser;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RoutingSectionsDTO {

    @JsonIgnore
    private String routingId;
    private String codice;
    private String descrizione;
    private String flgAttiva;
    private String flgDelete;
    private String flgInsert;
    private String flgReadonly;
    private String flgUpdate;

    public RoutingSectionsDTO(String routingId, String codice, String descrizione, String flgAttiva, String flgDelete,
            String flgInsert, String flgReadonly, String flgUpdate) {
        this.routingId = routingId;
        this.codice = codice;
        this.descrizione = descrizione;
        this.flgAttiva = flgAttiva;
        this.flgDelete = flgDelete;
        this.flgInsert = flgInsert;
        this.flgReadonly = flgReadonly;
        this.flgUpdate = flgUpdate;
    }

    public String getCodice() {
        return codice;
    }

    public String getFlgAttiva() {
        return flgAttiva;
    }

    public void setFlgAttiva(String flgAttiva) {
        this.flgAttiva = flgAttiva;
    }

    public String getFlgDelete() {
        return flgDelete;
    }

    public void setFlgDelete(String flgDelete) {
        this.flgDelete = flgDelete;
    }

    public String getFlgInsert() {
        return flgInsert;
    }

    public void setFlgInsert(String flgInsert) {
        this.flgInsert = flgInsert;
    }

    public String getFlgReadonly() {
        return flgReadonly;
    }

    public void setFlgReadonly(String flgReadonly) {
        this.flgReadonly = flgReadonly;
    }

    public String getFlgUpdate() {
        return flgUpdate;
    }

    public void setFlgUpdate(String flgUpdate) {
        this.flgUpdate = flgUpdate;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String id) {
        this.routingId = id;
    }

}
