package com.retexspa.xr.ms.iam.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class SostituzioniBadgeQueryDTO {

    private String id;
    private String utentiId;

    private String badgeId;

    private LocalDateTime dataAssegnazione;
    private LocalDateTime dataBlocco;
    private LocalDateTime dataSblocco;
    private LocalDateTime dataRiconsegna;

    private String causale;

    private String stato;
    private Long version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
