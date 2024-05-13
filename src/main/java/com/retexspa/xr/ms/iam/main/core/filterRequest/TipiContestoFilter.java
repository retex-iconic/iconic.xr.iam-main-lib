package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

public class TipiContestoFilter {
    private String id;
    private String codice;
    private String nome;
    private String descrizione;
    private String flgGerarchia;
    private Long version;
    public TipiContestoFilter() {
    }
    public TipiContestoFilter(
            @JsonProperty("id") String id,
            @JsonProperty("codice") String codice,
            @JsonProperty("descrizione") String descrizione,
            @JsonProperty("nome") String nome,
            @JsonProperty("flgGerarchia") String flgGerarchia,
            @JsonProperty("version") Long version
    ) {
        this.id = id;
        this.codice = codice;
        this.nome = nome;
        this.descrizione = descrizione;
        this.flgGerarchia = flgGerarchia;
        this.version = version;
    }
    public static TipiContestoFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        TipiContestoFilter filter = new TipiContestoFilter();
        if(map != null){
            filter.setId((String) map.get("id"));
            filter.setCodice((String) map.get("codice"));
            filter.setNome((String) map.get("nome"));
            filter.setDescrizione((String) map.get("descrizione"));
            filter.setFlgGerarchia((String) map.get("flgGerarchia"));
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

    public String getFlgGerarchia() {
        return flgGerarchia;
    }

    public void setFlgGerarchia(String flgGerarchia) {
        this.flgGerarchia = flgGerarchia;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
