package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

public class UtentiFilter {
    private String id;
    private String idAccount;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private Long version;

    public UtentiFilter() {
    }

    public UtentiFilter(
            @JsonProperty("id") String id,
            @JsonProperty("idAccount") String idAccount,
            @JsonProperty("nome") String nome,
            @JsonProperty("cognome") String cognome,
            @JsonProperty("codiceFiscale") String codiceFiscale,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.idAccount = idAccount;
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.version = version;
    }

    public static UtentiFilter createFilterFromMap(Object obj) {

        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        UtentiFilter filter = new UtentiFilter();
        if (map != null) {
            filter.setId((String) map.get("id"));
            filter.setIdAccount((String) map.get("idAccount"));
            filter.setNome((String) map.get("nome"));  
            filter.setCognome((String) map.get("cognome"));
            filter.setCodiceFiscale((String) map.get("codiceFiscale"));
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
