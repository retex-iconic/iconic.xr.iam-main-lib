package com.retexspa.xr.ms.iam.main.core.dto.sostituzioniBadge;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SostituzioniBadgeUpdateDTO {

    @JsonProperty("data_assegnazione")
    private LocalDateTime dataAssegnazione;
    @JsonProperty("data_blocco")
    private LocalDateTime dataBlocco;
    @JsonProperty("data_sblocco")
    private LocalDateTime dataSblocco;
    @JsonProperty("data_riconsegna")
    private LocalDateTime dataRiconsegna;
    @JsonProperty("causale")
    private String causale;
    
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

    
}
