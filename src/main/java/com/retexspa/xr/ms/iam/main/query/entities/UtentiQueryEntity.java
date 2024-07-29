package com.retexspa.xr.ms.iam.main.query.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.retexspa.xr.ms.iam.main.core.dto.utenti.UtentiBaseDTO;

@Entity
@Table(name = "utenti", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "id_account" }, name = "uk_utenti") }, indexes = {
                @Index(name = "index_utenti_id", columnList = "id"),
                @Index(name = "index_utenti_nome", columnList = "nome"),
                @Index(name = "index_utenti_cognome", columnList = "cognome"),
                @Index(name = "index_utenti_id_account", columnList = "id_account"),
                @Index(name = "index_utenti_codice_fiscale", columnList = "codice_fiscale")
        })
public class UtentiQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "id_account")
    private String idAccount;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    @Column(name = "version")
    private Long version;

    // master detail
    // @OneToMany(fetch = FetchType.EAGER, mappedBy = "societa")
    // @JsonIgnore
    // private Set<UtentiSocietaQueryEntity> utentiSocieta;

    public UtentiQueryEntity() {
    }

    public UtentiQueryEntity(@NonNull String id, UtentiBaseDTO dto, Long version) {
        this.id = id;
        this.idAccount = dto.getIdAccount();
        this.nome = dto.getNome();
        this.cognome = dto.getCognome();
        this.codiceFiscale = dto.getCodiceFiscale();
        this.version = version;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
