package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

public class NotificheFilter {
    private String id;
    private String applicazioneId;
    private String codice;
    private String titolo;
    private String dettaglio;
    private String icone;
    private String flgAttiva;
    private String routingId;
    private Long version;
    public NotificheFilter() {
    }
    public  NotificheFilter(
            @JsonProperty("id") String id,
            @JsonProperty("applicazioneId") String applicazioneId,
            @JsonProperty("codice") String codice,
            @JsonProperty("titolo") String titolo,
            @JsonProperty("dettaglio") String dettaglio,
            @JsonProperty("icone") String icone,
            @JsonProperty("flgAttiva") String flgAttiva,
            @JsonProperty("routingId") String routingId,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.applicazioneId = applicazioneId;
        this.codice = codice;
        this.titolo = titolo;
        this.dettaglio = dettaglio;
        this.icone = icone;
        this.flgAttiva = flgAttiva;
        this.routingId = routingId;
        this.version = version;
    }
    public static NotificheFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        NotificheFilter filter = new NotificheFilter();
        if(map != null){
            filter.setId((String) map.get("id"));
            filter.setApplicazioneId((String) map.get("applicazioneId"));
            filter.setCodice((String) map.get("codice"));
            filter.setTitolo((String) map.get("titolo"));
            filter.setDettaglio((String) map.get("dettaglio"));
            filter.setIcone((String) map.get("icone"));
            filter.setFlgAttiva((String) map.get("flgAttiva"));
            filter.setRoutingId((String) map.get("routingId"));
            Object version = map.get("version");
            if(version != null){
                if(version instanceof Integer){
                    filter.setVersion(Long.valueOf((Integer) version));
                } else if (version instanceof Long){
                    filter.setVersion((Long) version);
                }
            }
        }
        return filter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicazioneId() {
        return applicazioneId;
    }

    public void setApplicazioneId(String applicazioneId) {
        this.applicazioneId = applicazioneId;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDettaglio() {
        return dettaglio;
    }

    public void setDettaglio(String dettaglio) {
        this.dettaglio = dettaglio;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getFlgAttiva() {
        return flgAttiva;
    }

    public void setFlgAttiva(String flgAttiva) {
        this.flgAttiva = flgAttiva;
    }

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
