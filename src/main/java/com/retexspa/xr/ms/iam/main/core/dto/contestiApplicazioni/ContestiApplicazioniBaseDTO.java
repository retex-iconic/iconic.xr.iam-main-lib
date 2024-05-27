package com.retexspa.xr.ms.iam.main.core.dto.contestiApplicazioni;

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
public class ContestiApplicazioniBaseDTO {

    @NotNull(message = "codice is mandatory")
    @NotEmpty(message = "codice is mandatory")
    @NotBlank(message = "codice is mandatory")
    private String codice;

    @NotNull(message = "nome is mandatory")
    private String nome;

    @NotNull(message = "descrizione is mandatory")
    private String descrizione;

    @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flg Acquisizione Auto not valid")
    private String flgAcquisizioneAuto;

    @NotNull(message = "tipoContestoApplicazioneId is mandatory")
    private String tipoContestoApplicazioneId;

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

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

    public String getFlgAcquisizioneAuto() {
        return flgAcquisizioneAuto;
    }

    public void setFlgAcquisizioneAuto(String flgAcquisizioneAuto) {
        this.flgAcquisizioneAuto = flgAcquisizioneAuto;
    }

    public String getTipoContestoApplicazioneId() {
        return tipoContestoApplicazioneId;
    }

    public void setTipoContestoApplicazioneId(String tipoContestoApplicazioneId) {
        this.tipoContestoApplicazioneId = tipoContestoApplicazioneId;
    }

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public static String getAggregateName() {
        return "ContestiApplicazioniAggregate";
    }

    public static String getName() {
        return "ContestiApplicazioni";
    }
}
