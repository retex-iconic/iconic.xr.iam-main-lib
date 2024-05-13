package com.retexspa.xr.ms.iam.main.core.dto.configUser;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class NotificheDTO {

    @JsonIgnore
    private String routingId;
    private String codice;
    private String dettaglio;
    private String flgAttiva;
    private String icone;
    private String titolo;  
    private String routingCharId;        
    
    public NotificheDTO(String routingId, String codice, String dettaglio, String flgAttiva, String icone,
            String titolo, String routingCharId) {
        this.routingId = routingId;
        this.codice = codice;
        this.dettaglio = dettaglio;
        this.flgAttiva = flgAttiva;
        this.icone = icone;
        this.titolo = titolo;
        this.routingCharId = routingCharId;
    }

    
    public String getRoutingId() {
        return routingId;
    }
    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }
    public String getCodice() {
        return codice;
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }
    public String getDettaglio() {
        return dettaglio;
    }
    public void setDettaglio(String dettaglio) {
        this.dettaglio = dettaglio;
    }
    public String getFlgAttiva() {
        return flgAttiva;
    }
    public void setFlgAttiva(String flgAttiva) {
        this.flgAttiva = flgAttiva;
    }
    public String getIcone() {
        return icone;
    }
    public void setIcone(String icone) {
        this.icone = icone;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }


    public String getRoutingCharId() {
        return routingCharId;
    }


    public void setRoutingCharId(String routingCharId) {
        this.routingCharId = routingCharId;
    }

    
}
