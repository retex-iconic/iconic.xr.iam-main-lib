package com.retexspa.xr.ms.iam.main.core.dto.anagAttributiUtenti;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AnagAttributiUtentiUpdateDTO {

    private String nomeAttributo;

    private Integer posizione;

    private String tipo;

    private String formato;

    @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flg Cifrato not valid")
    private String flgCifrato;

    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.CheckSN.class, message = "Flg Unico not valid")
    private String flgUnico;

    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.CheckSN.class, message = "Flg Obbligatorio not valid")
    private String flgObbligatorio ;

    private String defaultValue;

    private String checkFunction;

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
}
