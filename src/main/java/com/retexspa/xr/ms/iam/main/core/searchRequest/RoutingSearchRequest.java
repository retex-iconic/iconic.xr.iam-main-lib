package com.retexspa.xr.ms.iam.main.core.searchRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.BaseSortPagination;

import java.util.List;

public class RoutingSearchRequest extends BaseSortPagination {

    private String id;
    private String routingCharId;
    private String titolo;
    private String urlLink;
    private String icone;
    private String  subtitolo;
    private String iconicApplicazioniId;
    private String flgGdpr;
    private String nodoId;
    private Long version;

    public RoutingSearchRequest(
            @JsonProperty("page") Integer page,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("sort") List<BaseSort> sort,
            @JsonProperty("id") String id,
            @JsonProperty("routingCharId") String routingCharId,
            @JsonProperty("titolo") String titolo,
            @JsonProperty("urlLink") String urlLink,
            @JsonProperty("icone") String icone,
            @JsonProperty("iconicApplicazioniId") String iconicApplicazioniId,
            @JsonProperty("flgGdpr") String flgGdpr,
            @JsonProperty("nodoId") String nodoId,
            @JsonProperty("version") Long version
    ) {
        super(page, limit, sort);
        this.id = id;
        this.routingCharId = routingCharId;
        this.titolo = titolo;
        this.urlLink = urlLink;
        this.icone = icone;
        this.iconicApplicazioniId = iconicApplicazioniId;
        this.flgGdpr = flgGdpr;
        this.nodoId = nodoId;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoutingCharId() {
        return routingCharId;
    }

    public void setRoutingCharId(String routingCharId) {
        this.routingCharId = routingCharId;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getSubtitolo() {
        return subtitolo;
    }

    public void setSubtitolo(String subtitolo) {
        this.subtitolo = subtitolo;
    }

    public String getIconicApplicazioniId() {
        return iconicApplicazioniId;
    }

    public void setIconicApplicazioniId(String iconicApplicazioniId) {
        this.iconicApplicazioniId = iconicApplicazioniId;
    }

    public String getFlgGdpr() {
        return flgGdpr;
    }

    public void setFlgGdpr(String flgGdpr) {
        this.flgGdpr = flgGdpr;
    }

    public String getNodoId() {
        return nodoId;
    }

    public void setNodoId(String nodoId) {
        this.nodoId = nodoId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
