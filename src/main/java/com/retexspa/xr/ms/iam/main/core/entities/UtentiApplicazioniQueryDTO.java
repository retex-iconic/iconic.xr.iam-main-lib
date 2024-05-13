package com.retexspa.xr.ms.iam.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class UtentiApplicazioniQueryDTO {

    private String id;
    private String utenteId;
    private String contestoId;
    private String ruoloId;
    private LocalDateTime dataInizioValidita;
    private LocalDateTime dataFineValidita;
    @EnumValidator(enumClazz = Enums.CheckSN.class)
    private String flgAcquisizioneAuto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
