package com.retexspa.xr.ms.iam.main.core.filterRequest;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicazioniFilter {
    private String id;
    private String codice;
    private String nome;
    private String descrizione;
    private String societaId;
    private String iconicApplicazioniId;
    //private byte[] immagine;
    private String flgRuoloUnico;
    private Long version;

    public ApplicazioniFilter() {
    }

    public ApplicazioniFilter(
            @JsonProperty("id") String id,
            @JsonProperty("codice") String codice,
            @JsonProperty("nome") String nome,
            @JsonProperty("descrizione") String descrizione,
            @JsonProperty("societaId") String societaId,
            @JsonProperty("iconicApplicazioniId") String iconicApplicazioniId,
           // @JsonProperty("immagine") byte[] immagine,
            @JsonProperty("flgRuoloUnico") String flgRuoloUnico,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.codice = codice;
        this.nome = nome;
        this.descrizione = descrizione;
        this.societaId = societaId;
        this.iconicApplicazioniId = iconicApplicazioniId;
        //this.immagine = immagine;
        this.flgRuoloUnico = flgRuoloUnico;
        this.version = version;
    }

    public static ApplicazioniFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        ApplicazioniFilter filter = new ApplicazioniFilter();
        if (map != null) {
            filter.setId((String) map.get("id"));
            filter.setCodice((String) map.get("codice"));
            filter.setNome((String) map.get("nome"));
            filter.setDescrizione((String) map.get("descrizione"));
            filter.setSocietaId((String) map.get("societaId"));
            filter.setIconicApplicazioniId((String) map.get("iconicApplicazioniId"));
            //filter.setImmagine((byte[]) map.get("immagine"));
            filter.setFlgRuoloUnico((String) map.get("flgRuoloUnico"));
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

    public String getIconicApplicazioniId() {
        return iconicApplicazioniId;
    }

    public void setIconicApplicazioniId(String iconicApplicazioniId) {
        this.iconicApplicazioniId = iconicApplicazioniId;
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

    public String getSocietaId() {
        return this.societaId;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
    }

    /* public byte[] getImmagine() {
        return this.immagine;
    }

    public void setImmagine(byte[] immagine) {
        this.immagine = immagine;
    } */

    public String getFlgRuoloUnico() {
        return this.flgRuoloUnico;
    }

    public void setFlgRuoloUnico(String flgRuoloUnico) {
        this.flgRuoloUnico = flgRuoloUnico;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
