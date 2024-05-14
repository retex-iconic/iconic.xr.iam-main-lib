package com.retexspa.xr.ms.iam.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class RoutingQueryDTO {
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

    public void setIconicApplicazioniId(String applicazioneId) {
        this.iconicApplicazioniId = applicazioneId;
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
