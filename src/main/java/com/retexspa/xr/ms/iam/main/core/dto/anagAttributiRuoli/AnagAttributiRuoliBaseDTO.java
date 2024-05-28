package com.retexspa.xr.ms.iam.main.core.dto.anagAttributiRuoli;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AnagAttributiRuoliBaseDTO {

    @NotNull(message = "nomeAttributo is mandatory")
    @NotEmpty(message = "nomeAttributo is mandatory")
    @NotBlank(message = "nomeAttributo is mandatory")
    private String nomeAttributo;
    @NotNull(message = "applicazioneId is mandatory")
    @NotEmpty(message = "applicazioneId is mandatory")
    @NotBlank(message = "applicazioneId is mandatory")
    private String applicazioneId;
    @NotNull(message = "shareApplicazioneId is mandatory")
    @NotEmpty(message = "shareApplicazioneId is mandatory")
    @NotBlank(message = "shareApplicazioneId is mandatory")
    private String shareApplicazioneId;
    @NotNull(message = "tipo is mandatory")
    @NotEmpty(message = "tipo is mandatory")
    @NotBlank(message = "tipo is mandatory")
    private String tipo;
    private String formato;
    @NotNull(message = "posizione is mandatory")
    private Integer posizione;
    @EnumValidator(enumClazz = Enums.CheckSN.class)
    private String flgCifrato;
    @EnumValidator(enumClazz = Enums.CheckSN.class)
    private String flgUnico;
    @EnumValidator(enumClazz = Enums.CheckSN.class)
    private String flgObbligatorio;
    private String defaultValue;
    private String checkFunction;

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public String getNomeAttributo() {
        return nomeAttributo;
    }

    public void setNomeAttributo(String nomeAttributo) {
        this.nomeAttributo = nomeAttributo;
    }

    public String getApplicazioneId() {
        return applicazioneId;
    }

    public void setApplicazioneId(String applicazioneId) {
        this.applicazioneId = applicazioneId;
    }

    public String getShareApplicazioneId() {
        return shareApplicazioneId;
    }

    public void setShareApplicazioneId(String shareApplicazioneId) {
        this.shareApplicazioneId = shareApplicazioneId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Integer getPosizione() {
        return posizione;
    }

    public void setPosizione(Integer posizione) {
        this.posizione = posizione;
    }

    public String getFlgCifrato() {
        return flgCifrato;
    }

    public void setFlgCifrato(String flgCifrato) {
        this.flgCifrato = flgCifrato;
    }

    public String getFlgUnico() {
        return flgUnico;
    }

    public void setFlgUnico(String flgUnico) {
        this.flgUnico = flgUnico;
    }

    public String getFlgObbligatorio() {
        return flgObbligatorio;
    }

    public void setFlgObbligatorio(String flgObbligatorio) {
        this.flgObbligatorio = flgObbligatorio;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getCheckFunction() {
        return checkFunction;
    }

    public void setCheckFunction(String checkFunction) {
        this.checkFunction = checkFunction;
    }

    public static String getAggregateName() {
        return "AnagAttributiRuoliAggregate";
    }

    public static String getName() {
        return "AnagAttributiRuoli";
    }
}
