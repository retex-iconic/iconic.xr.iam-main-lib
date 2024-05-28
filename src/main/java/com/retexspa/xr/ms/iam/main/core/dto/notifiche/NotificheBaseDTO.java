package com.retexspa.xr.ms.iam.main.core.dto.notifiche;

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
public class NotificheBaseDTO {
    @NotNull(message = "iconicApplicazioniId is mandatory")
    @NotEmpty(message = "iconicApplicazioniId is mandatory")
    @NotBlank(message = "iconicApplicazioniId is mandatory")
    private String iconicApplicazioniId;

    @NotNull(message = "codice is mandatory")
    @NotEmpty(message = "codice is mandatory")
    @NotBlank(message = "codice is mandatory")
    private String codice;

    @NotNull(message = "titolo is mandatory")
    private String titolo;
    private String dettaglio;
    private String icone;
    @EnumValidator(enumClazz = Enums.CheckSN.class , message = "flg_attiva not valid")
    private String flgAttiva;

    @NotNull(message = "routingId is mandatory")
    @NotEmpty(message = "routingId is mandatory")
    @NotBlank(message = "routingId is mandatory")
    private String routingId;

    public String getIconicApplicazioniId() {
        return iconicApplicazioniId;
    }

    public void setIconicApplicazioniId(String iconicApplicazioniId) {
        this.iconicApplicazioniId = iconicApplicazioniId;
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

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public static String getAggregateName() {
        return "NotificheAggregate";
    }

    public static String getName() {
        return "Notifiche";
    }
}
