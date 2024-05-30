package com.retexspa.xr.ms.iam.main.core.filterRequest;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RuoliApplicazioneFilter {
    private String id;
    private String codice;
    private String nome;
    private String descrizione;
    private String flgAttivo;
    private Integer livelloIam;
    private Long version;
    private String applicazioniId;
    private String societaId;

    public RuoliApplicazioneFilter() {
    }

    public RuoliApplicazioneFilter(
            @JsonProperty("id") String id,
            @JsonProperty("codice") String codice,
            @JsonProperty("nome") String nome,
            @JsonProperty("descrizione") String descrizione,
            @JsonProperty("flgAttivo") String flgAttivo,
            @JsonProperty("livelloIam") Integer livelloIam,
            @JsonProperty("applicazioniId") String applicazioniId,
            @JsonProperty("societaId") String societaId,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.codice = codice;
        this.nome = nome;
        this.descrizione = descrizione;
        this.flgAttivo = flgAttivo;
        this.livelloIam = livelloIam;
        this.applicazioniId = applicazioniId;
        this.societaId = societaId;
        this.version = version;
    }

    public static RuoliApplicazioneFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        RuoliApplicazioneFilter filter = new RuoliApplicazioneFilter();
        if (map != null) {
            filter.setId((String) map.get("id"));
            filter.setCodice((String) map.get("codice"));
            filter.setNome((String) map.get("nome"));
            filter.setDescrizione((String) map.get("descrizione"));
            filter.setFlgAttivo((String) map.get("flgAttivo"));
            filter.setLivelloIam((Integer) map.get("livelloIam"));
            filter.setApplicazioniId((String) map.get("applicazioniId"));
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getApplicazioniId() {
        return applicazioniId;
    }

    public void setApplicazioniId(String applicazioniId) {
        this.applicazioniId = applicazioniId;
    }

    public String getSocietaId() {
        return societaId;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
    }
}
