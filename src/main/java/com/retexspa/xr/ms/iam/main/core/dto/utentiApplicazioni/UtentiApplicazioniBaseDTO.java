package com.retexspa.xr.ms.iam.main.core.dto.utentiApplicazioni;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UtentiApplicazioniBaseDTO {

    @NotNull(message = "utenteId is mandatory")
    @NotEmpty(message = "utenteId is mandatory")
    @NotBlank(message = "utenteId is mandatory")
    private String utenteId;

    @NotNull(message = "contestoId is mandatory")
    @NotEmpty(message = "contestoId is mandatory")
    @NotBlank(message = "contestoId is mandatory")
    private String contestoId;

    @NotNull(message = "ruoloId is mandatory")
    @NotEmpty(message = "ruoloId is mandatory")
    @NotBlank(message = "ruoloId is mandatory")
    private String ruoloId;

    @NotNull(message = "data Inizio Validita is mandatory")
    private LocalDateTime dataInizioValidita;
    private LocalDateTime dataFineValidita;

    @EnumValidator(enumClazz = Enums.CheckSN.class)
    private String flgAcquisizioneAuto;

    public String getUtenteId() {
        return utenteId;
    }

    public void setUtenteId(String utenteId) {
        this.utenteId = utenteId;
    }

    public String getContestoId() {
        return contestoId;
    }

    public void setContestoId(String contestoId) {
        this.contestoId = contestoId;
    }

    public String getRuoloId() {
        return ruoloId;
    }

    public void setRuoloId(String ruoloId) {
        this.ruoloId = ruoloId;
    }

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

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public static String getAggregateName() {
        return "UtentiApplicazioniAggregate";
    }

    public static String getName() {
        return "UtentiApplicazioni";
    }
}
