package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

public class TipiContestoApplicazioneFilter {
    private String id;
    private String applicazioneId;
    private String tipiContestoId;
    private Long version;
    private String tassonomiaId;
    public TipiContestoApplicazioneFilter() {
    }
    public TipiContestoApplicazioneFilter(
            @JsonProperty("id") String id,
            @JsonProperty("applicazioneId") String applicazioneId,
            @JsonProperty("tipiContestoId") String tipiContestoId,
            @JsonProperty("tassonomiaId") String tassonomiaId,
            @JsonProperty("version") Long version
    ) {
        this.id = id;
        this.applicazioneId = applicazioneId;
        this.tipiContestoId = tipiContestoId;
        this.version = version;
        this.tassonomiaId = tassonomiaId;
    }
    public static TipiContestoApplicazioneFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        TipiContestoApplicazioneFilter filter = new TipiContestoApplicazioneFilter();
        if(map != null){
            filter.setId((String) map.get("id"));
            filter.setApplicazioneId((String) map.get("applicazioneId"));
            filter.setTipiContestoId((String) map.get("tipiContestoId"));
            filter.setTassonomiaId((String) map.get("tassonomiaId"));
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

    public String getApplicazioneId() {
        return applicazioneId;
    }

    public void setApplicazioneId(String applicazioneId) {
        this.applicazioneId = applicazioneId;
    }

    public String getTipiContestoId() {
        return tipiContestoId;
    }

    public void setTipiContestoId(String tipiContestoId) {
        this.tipiContestoId = tipiContestoId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTassonomiaId() {
        return tassonomiaId;
    }

    public void setTassonomiaId(String tassonomiaId) {
        this.tassonomiaId = tassonomiaId;
    }
}
