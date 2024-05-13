package com.retexspa.xr.ms.iam.main.core.dto.applicazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ApplicazioniUpdateDTO {

    private String descrizione;
    private String nome;
    private byte[] immagine;
    @EnumValidator(enumClazz = Enums.CheckSN.class , message = "FlgRuoloUnico not valid")
    private String flgRuoloUnico;


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

    public byte[] getImmagine() {
        return immagine;
    }

    public void setImmagine(byte[] immagine) {
        this.immagine = immagine;
    }

    public String getFlgRuoloUnico() {
        return flgRuoloUnico;
    }

    public void setFlgRuoloUnico(String flgRuoloUnico) {
        this.flgRuoloUnico = flgRuoloUnico;
    }
}
