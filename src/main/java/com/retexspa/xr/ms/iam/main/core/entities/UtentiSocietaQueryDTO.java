package com.retexspa.xr.ms.iam.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class UtentiSocietaQueryDTO {

    private String id;
    private String idAccount;

    private String nome;

    private String cognome;

    private LocalDateTime dataInizioValidita;

    private LocalDateTime dataFineValidita;

    private String matricola;

    private String codiceBadge;

    private String statoBadge;

    private String codiceFiscale;

    private String indirrizoEmail;

    private String upn;

    private String pwd;

    private String societaId;

    private Long version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public LocalDateTime getDataInizioValidita() {
        return dataInizioValidita;
    }

    public void setDataInizioValidita(LocalDateTime dataInizioValidita) {
        this.dataInizioValidita = dataInizioValidita;
    }

    public LocalDateTime getDataFineValidita() {
        return dataFineValidita;
    }

    public void setDataFineValidita(LocalDateTime dataFineValidita) {
        this.dataFineValidita = dataFineValidita;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getCodiceBadge() {
        return codiceBadge;
    }

    public void setCodiceBadge(String codiceBadge) {
        this.codiceBadge = codiceBadge;
    }

    public String getStatoBadge() {
        return statoBadge;
    }

    public void setStatoBadge(String statoBadge) {
        this.statoBadge = statoBadge;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getIndirrizoEmail() {
        return indirrizoEmail;
    }

    public void setIndirrizoEmail(String indirrizoEmail) {
        this.indirrizoEmail = indirrizoEmail;
    }

    public String getUpn() {
        return upn;
    }

    public void setUpn(String upn) {
        this.upn = upn;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSocietaId() {
        return societaId;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
