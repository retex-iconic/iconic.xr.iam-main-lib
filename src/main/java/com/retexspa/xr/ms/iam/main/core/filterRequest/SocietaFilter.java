package com.retexspa.xr.ms.iam.main.core.filterRequest;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SocietaFilter {
    private String id;
    private String codice;
    private String nome;
    private String descrizione;
    private String gerarchiaId;
    private Long version;    

    public SocietaFilter() {
    }

    public SocietaFilter(
            @JsonProperty("id") String id,
            @JsonProperty("codice") String codice,
            @JsonProperty("nome") String nome,
            @JsonProperty("descrizione") String descrizione,
            @JsonProperty("gerarchiaId") String gerarchiaId,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.codice = codice;
        this.nome = nome;
        this.descrizione = descrizione;
        this.gerarchiaId = gerarchiaId;
        this.version = version;
    }

    public static SocietaFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        SocietaFilter filter = new SocietaFilter();
        if(map != null){
            filter.setId((String) map.get("id"));
            filter.setCodice((String) map.get("codice"));
            filter.setNome((String) map.get("nome"));
            filter.setDescrizione((String) map.get("descrizione"));
            filter.setGerarchiaId((String) map.get("gerarchiaId"));
            Object version = map.get("version");
            if(version != null){
                if(version instanceof Integer){
                    filter.setVersion(Long.valueOf((Integer) version));
                } else if (version instanceof Long){
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

    public String getGerarchiaId() {
        return gerarchiaId;
    }

    public void setGerarchiaId(String gerarchiaId) {
        this.gerarchiaId = gerarchiaId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    
}
