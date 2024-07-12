package com.retexspa.xr.ms.iam.main.core.dto.sostituzioniBadge;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SostituzioniBadgeBaseDTO {

    @NotNull(message = "Utenti Societa is mandatory")
    @NotEmpty(message = "Utenti Societa is mandatory")
    @NotBlank(message = "Utenti Societa is mandatory")
    private String utentiId;

    @NotNull(message = "Badge is mandatory")
    @NotEmpty(message = "Badge is mandatory")
    @NotBlank(message = "Badge is mandatory")
    private String badgeId;

    @NotNull(message = "Data assegnazione is mandatory")
    private LocalDateTime dataAssegnazione;
    private LocalDateTime dataBlocco;
    private LocalDateTime dataSblocco;
    private LocalDateTime dataRiconsegna;

    @NotNull(message = "Causale is mandatory")
    @NotEmpty(message = "Causale is mandatory")
    @NotBlank(message = "Causale is mandatory")
    private String causale;

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public String getUtentiId() {
        return utentiId;
    }

    public void setUtentiId(String utentiId) {
        this.utentiId = utentiId;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(String badgeId) {
        this.badgeId = badgeId;
    }

    public LocalDateTime getDataAssegnazione() {
        return dataAssegnazione;
    }

    public void setDataAssegnazione(LocalDateTime dataAssegnazione) {
        this.dataAssegnazione = dataAssegnazione;
    }

    public LocalDateTime getDataBlocco() {
        return dataBlocco;
    }

    public void setDataBlocco(LocalDateTime dataBlocco) {
        this.dataBlocco = dataBlocco;
    }

    public LocalDateTime getDataSblocco() {
        return dataSblocco;
    }

    public void setDataSblocco(LocalDateTime dataSblocco) {
        this.dataSblocco = dataSblocco;
    }

    public LocalDateTime getDataRiconsegna() {
        return dataRiconsegna;
    }

    public void setDataRiconsegna(LocalDateTime dataRiconsegna) {
        this.dataRiconsegna = dataRiconsegna;
    }

    public String getCausale() {
        return causale;
    }

    public void setCausale(String causale) {
        this.causale = causale;
    }

    public static String getAggregateName() {
        return "SostituzioniBadgeAggregate";
    }

    public static String getName() {
        return "SostituzioniBadge";
    }
    
    

}
