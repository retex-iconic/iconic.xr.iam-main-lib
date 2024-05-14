package com.retexspa.xr.ms.iam.main.core.dto.routing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RoutingBaseDTO {

    @NotNull(message = "routingCharId is mandatory")
    private String routingCharId;

    @NotNull(message = "titolo is mandatory")
    private String titolo;
    @NotNull(message = "urlLink is mandatory")
    private String urlLink;
    private String icone;

    @NotNull(message = "iconicApplicazioniId is mandatory")
    @NotEmpty(message = "iconicApplicazioniId is mandatory")
    @NotBlank(message = "iconicApplicazioniId is mandatory")
    private String iconicApplicazioniId;
    private String subtitolo;
    @EnumValidator(enumClazz = Enums.CheckSN.class , message = "FlgGdpr not valid")
    private String flgGdpr;
    private String nodoId;

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

    public String getIconicApplicazioniId() {
        return iconicApplicazioniId;
    }

    public void setIconicApplicazioniId(String iconicApplicazioniId) {
        this.iconicApplicazioniId = iconicApplicazioniId;
    }

    public String getSubtitolo() {
        return subtitolo;
    }

    public void setSubtitolo(String subtitolo) {
        this.subtitolo = subtitolo;
    }

    public String getFlgGdpr() {
        return flgGdpr;
    }

    public void setFlgGdpr(String flgGdpr) {
        this.flgGdpr = flgGdpr;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getNodoId() {
        return nodoId;
    }

    public void setNodoId(String nodoId) {
        this.nodoId = nodoId;
    }

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

}
