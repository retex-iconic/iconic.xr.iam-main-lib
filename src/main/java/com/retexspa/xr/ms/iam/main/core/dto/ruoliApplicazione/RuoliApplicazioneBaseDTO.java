package com.retexspa.xr.ms.iam.main.core.dto.ruoliApplicazione;

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
public class RuoliApplicazioneBaseDTO {
    @NotNull(message = "codice is mandatory")
    @NotEmpty(message = "codice is mandatory")
    @NotBlank(message = "codice is mandatory")
    private String codice;

    @NotNull(message = "nome is mandatory")
    private String nome;

    @NotNull(message = "decrizione is mandatory")
    private String descrizione;

    @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flg Attivo not valid")
    @NotNull(message = "flgAttivo is mandatory")
    private String flgAttivo;

    @NotNull(message = "livelloIam is mandatory")
    private Integer livelloIam;

    @NotNull(message = "applicazioniId is mandatory")
    @NotEmpty(message = "applicazioniId is mandatory")
    @NotBlank(message = "applicazioniId is mandatory")
    private String applicazioniId;

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

    public String getApplicazioniId() {
        return applicazioniId;
    }

    public void setApplicazioniId(String applicazioniId) {
        this.applicazioniId = applicazioniId;
    }

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public static String getAggregateName() {
        return "RuoliApplicazioneAggregate";
    }

    public static String getName() {
        return "RuoliApplicazione";
    }
}
