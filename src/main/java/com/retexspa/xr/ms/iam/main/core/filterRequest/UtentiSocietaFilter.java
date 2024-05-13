package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

public class UtentiSocietaFilter {
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

    public UtentiSocietaFilter() {
    }

    public UtentiSocietaFilter(
            @JsonProperty("id") String id,
            @JsonProperty("idAccount") String idAccount,
            @JsonProperty("nome") String nome,
            @JsonProperty("cognome") String cognome,
            @JsonProperty("dataInizioValidita") LocalDateTime dataInizioValidita,
            @JsonProperty("dataFineValidita") LocalDateTime dataFineValidita,
            @JsonProperty("matricola") String matricola,
            @JsonProperty("codiceBadge") String codiceBadge,
            @JsonProperty("statoBadge") String statoBadge,
            @JsonProperty("codiceFiscale") String codiceFiscale,
            @JsonProperty("indirrizoEmail") String indirrizoEmail,
            @JsonProperty("upn") String upn,
            @JsonProperty("pwd") String pwd,
            @JsonProperty("societaId") String societaId,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.idAccount = idAccount;
        this.nome = nome;
        this.cognome = cognome;
        this.dataInizioValidita = dataInizioValidita;
        this.dataFineValidita = dataFineValidita;
        this.matricola = matricola;
        this.statoBadge = statoBadge;
        this.codiceFiscale = codiceFiscale;
        this.indirrizoEmail = indirrizoEmail;
        this.upn = upn;
        this.pwd = pwd;
        this.codiceBadge = codiceBadge;
        this.societaId = societaId;
        this.version = version;
    }

    public static UtentiSocietaFilter createFilterFromMap(Object obj) {

        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        UtentiSocietaFilter filter = new UtentiSocietaFilter();
        if (map != null) {
            filter.setId((String) map.get("id"));
            filter.setIdAccount((String) map.get("idAccount"));
            filter.setNome((String) map.get("nome"));
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            Object dataInizioValidita = map.get("dataInizioValidita");
            if (dataInizioValidita != null) {
                if (dataInizioValidita instanceof String) {
                    filter.setDataInizioValidita(
                            LocalDateTime.parse((String) map.get("dataInizioValidita"), formatter));
                } else if (dataInizioValidita instanceof LocalDateTime) {
                    filter.setDataInizioValidita((LocalDateTime) dataInizioValidita);
                }
            }
            Object dataFineValidita = map.get("dataFineValidita");
            if (dataFineValidita != null) {
                if (dataFineValidita instanceof String) {
                    filter.setDataFineValidita(
                            LocalDateTime.parse((String) map.get("dataFineValidita"), formatter));
                } else if (dataFineValidita instanceof LocalDateTime) {
                    filter.setDataFineValidita((LocalDateTime) dataFineValidita);
                }
            }
            filter.setCognome((String) map.get("cognome"));
            filter.setMatricola((String) map.get("matricola"));
            filter.setCodiceBadge((String) map.get("codiceBadge"));
            filter.setStatoBadge((String) map.get("statoBadge"));
            filter.setCodiceFiscale((String) map.get("codiceFiscale"));
            filter.setIndirrizoEmail((String) map.get("indirrizoEmail"));
            filter.setUpn((String) map.get("upn"));
            filter.setPwd((String) map.get("pwd"));
            filter.setSocietaId((String) map.get("societaId"));
            Object version = map.get("version");
            if (version != null) {
                if (version instanceof Integer) {
                    filter.setVersion(Long.valueOf((Integer) version));
                } else if (version instanceof Long) {
                    filter.setVersion((Long) version);
                }
            }
        }
        return filter;

    }

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
