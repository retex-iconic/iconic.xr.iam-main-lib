package com.retexspa.xr.ms.iam.main.core.dto.ruoliApplicazione;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RuoliApplicazioneUpdateDTO {


    private String nome;

    private String descrizione;

    @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flg Attivo not valid")
    private String flgAttivo;

    private Integer livelloIam;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFlgAttivo() {
        return flgAttivo;
    }

    public void setFlgAttivo(String flgAttivo) {
        this.flgAttivo = flgAttivo;
    }

    public Integer getLivelloIam() {
        return livelloIam;
    }

    public void setLivelloIam(Integer livelloIam) {
        this.livelloIam = livelloIam;
    }
}
