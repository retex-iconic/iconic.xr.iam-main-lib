package com.retexspa.xr.ms.iam.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class RuoliApplicazioneQueryDTO {

    private String id;

    private String codice;

    private String nome;

    private String descrizione;

    private String flgAttivo;

    private Integer livelloIam;

    private String applicazioniId;

    private Long version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
