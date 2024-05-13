package com.retexspa.xr.ms.iam.main.core.dto.sostituzioniBadge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SostituzioniBadgeUpdateDTO {

    @JsonProperty("dataAssegnazione")
    private LocalDateTime dataAssegnazione;
    @JsonProperty("dataBlocco")
    private LocalDateTime dataBlocco;
    @JsonProperty("dataSblocco")
    private LocalDateTime dataSblocco;
    @JsonProperty("dataRiconsegna")
    private LocalDateTime dataRiconsegna;

    @JsonProperty("causale")
    private String causale;
    @JsonProperty("stato")
    private String stato;

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
}
