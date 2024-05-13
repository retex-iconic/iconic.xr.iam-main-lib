package com.retexspa.xr.ms.iam.main.core.dto.utentiApplicazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

import java.time.LocalDateTime;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UtentiApplicazioniUpdateDTO {

    private LocalDateTime dataInizioValidita;
    private LocalDateTime dataFineValidita;

    @EnumValidator(enumClazz = Enums.CheckSN.class)
    private String flgAcquisizioneAuto;

    public LocalDateTime getDataInizioValidita() {
        return dataInizioValidita;
    }

    public void setDataInizioValidita(LocalDateTime dataInizioValidita) {
        this.dataInizioValidita = dataInizioValidita;
    }

    public LocalDateTime getDataFineValidita() {
        return dataFineValidita;
    }

    public void setDataFineValidita(LocalDateTime dataFineValidita) {
        this.dataFineValidita = dataFineValidita;
    }

    public String getFlgAcquisizioneAuto() {
        return flgAcquisizioneAuto;
    }

    public void setFlgAcquisizioneAuto(String flgAcquisizioneAuto) {
        this.flgAcquisizioneAuto = flgAcquisizioneAuto;
    }
}
