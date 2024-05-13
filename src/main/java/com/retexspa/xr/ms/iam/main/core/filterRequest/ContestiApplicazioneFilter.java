package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

public class ContestiApplicazioneFilter {

    private String id;
    private String codice;
    private String nome;
    private String descrizione;
    private String tipoContestoApplicazioneId;
    private String flgAcquisizioneAuto;
    private Long version;

    public ContestiApplicazioneFilter() {}

    public ContestiApplicazioneFilter(
            @JsonProperty("id") String id,
            @JsonProperty("codice") String codice,
            @JsonProperty("nome") String nome,
            @JsonProperty("descrizione") String descrizione,
            @JsonProperty("tipoContestoApplicazioneId") String tipoContestoApplicazioneId,
            @JsonProperty("flgAcquisizioneAuto") String flgAcquisizioneAuto,
            @JsonProperty("version") Long version
    ) {
        this.id = id;
        this.codice = codice;
        this.nome = nome;
        this.descrizione = descrizione;
        this.tipoContestoApplicazioneId = tipoContestoApplicazioneId;
        this.flgAcquisizioneAuto = flgAcquisizioneAuto;
        this.version = version;
    }

    public static ContestiApplicazioneFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        ContestiApplicazioneFilter filter = new ContestiApplicazioneFilter();
        if (map != null) {
            filter.setId((String) map.get("id"));
            filter.setCodice((String) map.get("codice"));
            filter.setDescrizione((String) map.get("descrizione"));
            filter.setNome((String) map.get("nome"));
            filter.setFlgAcquisizioneAuto((String) map.get("flgAcquisizioneAuto"));
            filter.setTipoContestoApplicazioneId((String) map.get("tipoContestoApplicazioneId"));
            Object version = map.get("version");
            if (version != null) {
                if (version instanceof Integer) {
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

    public String getTipoContestoApplicazioneId() {
        return tipoContestoApplicazioneId;
    }

    public void setTipoContestoApplicazioneId(String tipoContestoApplicazioneId) {
        this.tipoContestoApplicazioneId = tipoContestoApplicazioneId;
    }

    public String getFlgAcquisizioneAuto() {
        return flgAcquisizioneAuto;
    }

    public void setFlgAcquisizioneAuto(String flgAcquisizioneAuto) {
        this.flgAcquisizioneAuto = flgAcquisizioneAuto;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
