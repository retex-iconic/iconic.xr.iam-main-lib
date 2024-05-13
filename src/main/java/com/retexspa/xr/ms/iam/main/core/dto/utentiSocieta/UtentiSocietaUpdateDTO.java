package com.retexspa.xr.ms.iam.main.core.dto.utentiSocieta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UtentiSocietaUpdateDTO {

    private String nome;

    private String cognome;

    private LocalDateTime dataInizioValidita;

    private LocalDateTime dataFineValidita;

    private String codiceBadge;

    @EnumValidator(enumClazz = Enums.StatoBadge.class, message = "Stato Badge not valid")
    private String statoBadge;

    private String codiceFiscale;

    private String indirrizoEmail;

    private String pwd;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
