package com.retexspa.xr.ms.iam.main.core.dto.anagAttributiRuoli;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AnagAttributiRuoliUpdateDTO {
    private String nomeAttributo;
    private String shareApplicazioneId;
    private String tipo;
    private String formato;
    private Integer posizione;
    @EnumValidator(enumClazz = Enums.CheckSN.class)
    private String flgCifrato;
    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.CheckSN.class)
    private String flgUnico;
    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.CheckSN.class)
    private String flgObbligatorio;
    private String defaultValue;
    private String checkFunction;

    public String getNomeAttributo() {
        return nomeAttributo;
    }

    public void setNomeAttributo(String nomeAttributo) {
        this.nomeAttributo = nomeAttributo;
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
}
