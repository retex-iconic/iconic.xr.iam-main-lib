package com.retexspa.xr.ms.iam.main.core.dto.anagAttributiUtenti;

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
public class AnagAttributiUtentiBaseDTO {

    @NotNull(message = "nomeAttributo is mandatory")
    @NotEmpty(message = "nomeAttributo is mandatory")
    @NotBlank(message = "nomeAttributo is mandatory")
    private String nomeAttributo;

    @NotNull(message = "posizione is mandatory")
    private Integer posizione;

    @NotNull(message = "tipo is mandatory")
    @NotEmpty(message = "tipo is mandatory")
    @NotBlank(message = "tipo is mandatory")
    private String tipo;

    private String formato;

    @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flg Cifrato not valid")
    @NotNull(message = "flgCifrato is mandatory")
    private String flgCifrato;

    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.CheckSN.class, message = "Flg Unico not valid")
    @NotNull(message = "flgUnico is mandatory")
    private String flgUnico;

    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.CheckSN.class, message = "Flg Obbligatorio not valid")
    @NotNull(message = "flgObbligatorio is mandatory")
    private String flgObbligatorio ;

    private String defaultValue;

    private String checkFunction;

    @NotNull(message = "tipoContestoApplicazioneId is mandatory")
    @NotEmpty(message = "tipoContestoApplicazioneId is mandatory")
    @NotBlank(message = "tipoContestoApplicazioneId is mandatory")
    private String tipoContestoApplicazioneId;

    private String shareTipoContestoApplicazioneId;

    public String getNomeAttributo() {
        return nomeAttributo;
    }

    public void setNomeAttributo(String nomeAttributo) {
        this.nomeAttributo = nomeAttributo;
    }

    public Integer getPosizione() {
        return posizione;
    }

    public void setPosizione(Integer posizione) {
        this.posizione = posizione;
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

    public String getTipoContestoApplicazioneId() {
        return tipoContestoApplicazioneId;
    }

    public void setTipoContestoApplicazioneId(String tipoContestoApplicazioneId) {
        this.tipoContestoApplicazioneId = tipoContestoApplicazioneId;
    }

    public String getShareTipoContestoApplicazioneId() {
        return shareTipoContestoApplicazioneId;
    }

    public void setShareTipoContestoApplicazioneId(String shareTipoContestoApplicazioneId) {
        this.shareTipoContestoApplicazioneId = shareTipoContestoApplicazioneId;
    }

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public static String getAggregateName() {
        return "AnagAttributiUtentiAggregate";
    }

    public static String getName() {
        return "AnagAttributiUtenti";
    }
}
