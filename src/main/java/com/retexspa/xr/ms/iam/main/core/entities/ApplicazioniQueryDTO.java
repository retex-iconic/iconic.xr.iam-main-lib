package com.retexspa.xr.ms.iam.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class ApplicazioniQueryDTO {
    private String id;
    private String nome;
    private String codice;
    private String descrizione;
    private String societaId;
    private String iconicApplicazioniId;
    private byte[] immagine;
    private String flgRuoloUnico;
    private Long version;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodice() {
        return codice;
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getSocietaId() {
        return societaId;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    public String getIconicApplicazioniId() {
        return iconicApplicazioniId;
    }
    public void setIconicApplicazioniId(String iconicApplicazioniId) {
        this.iconicApplicazioniId = iconicApplicazioniId;
    }
}
