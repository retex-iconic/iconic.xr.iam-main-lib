package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

public class AttributiUtentiFilter {

    private String id;

    private String utenteApplicazioneId;

    private String attributoId;

    private String contestoId;

    private String valore;

    private Long version;

    public AttributiUtentiFilter() {
    }

    public AttributiUtentiFilter(
            @JsonProperty("id") String id,
            @JsonProperty("utenteApplicazioneId") String utenteApplicazioneId,
            @JsonProperty("attributoId") String attributoId,
            @JsonProperty("contestoId") String contestoId,
            @JsonProperty("valore") String valore,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.utenteApplicazioneId = utenteApplicazioneId;
        this.attributoId = attributoId;
        this.contestoId = contestoId;
        this.valore = valore;
        this.version = version;
    }

    public static AttributiUtentiFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        AttributiUtentiFilter filter = new AttributiUtentiFilter();
        if (map != null) {
            filter.setId((String) map.get("id"));
            filter.setValore((String) map.get("valore"));
            filter.setUtenteApplicazioneId((String) map.get("utenteApplicazioneId"));
            filter.setAttributoId((String) map.get("attributoId"));
            filter.setContestoId((String) map.get("contestoId"));
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

    public String getUtenteApplicazioneId() {
        return utenteApplicazioneId;
    }

    public void setUtenteApplicazioneId(String utenteApplicazioneId) {
        this.utenteApplicazioneId = utenteApplicazioneId;
    }

    public String getAttributoId() {
        return attributoId;
    }

    public void setAttributoId(String attributoId) {
        this.attributoId = attributoId;
    }

    public String getContestoId() {
        return contestoId;
    }

    public void setContestoId(String contestoId) {
        this.contestoId = contestoId;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
