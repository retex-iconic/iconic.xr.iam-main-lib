package com.retexspa.xr.ms.iam.main.core.dto.tipiContesto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TipiContestoUpdateDTO {
    private String descrizione;
    private String nome;
    @EnumValidator(enumClazz = Enums.CheckSN.class , message = "FlgGerarchia not valid")
    private String flgGerarchia;
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFlgGerarchia() {
        return flgGerarchia;
    }

    public void setFlgGerarchia(String flgGerarchia) {
        this.flgGerarchia = flgGerarchia;
    }
}
