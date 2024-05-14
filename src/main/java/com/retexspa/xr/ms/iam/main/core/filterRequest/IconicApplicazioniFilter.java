package com.retexspa.xr.ms.iam.main.core.filterRequest;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IconicApplicazioniFilter {
    private String id;
    private String codice;
    private String nome;
    private String descrizione;
    private Long version;

    public IconicApplicazioniFilter() {
    }

    public IconicApplicazioniFilter(
            @JsonProperty("id") String id,
            @JsonProperty("codice") String codice,
            @JsonProperty("nome") String nome,
            @JsonProperty("descrizione") String descrizione,          
            @JsonProperty("version") Long version) {
        this.id = id;
        this.codice = codice;
        this.nome = nome;
        this.descrizione = descrizione;     
        this.version = version;
    }

    public static IconicApplicazioniFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        IconicApplicazioniFilter filter = new IconicApplicazioniFilter();
        if (map != null) {
            filter.setId((String) map.get("id"));
            filter.setCodice((String) map.get("codice"));
            filter.setNome((String) map.get("nome"));
            filter.setDescrizione((String) map.get("descrizione"));
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
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodice() {
        return this.codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
