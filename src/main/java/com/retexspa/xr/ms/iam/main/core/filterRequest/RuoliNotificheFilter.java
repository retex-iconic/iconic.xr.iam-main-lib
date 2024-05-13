package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

public class RuoliNotificheFilter {
    private String id;
    private String notificaId;
    private String ruoloId;
    private Long version;
    public RuoliNotificheFilter() {
    }
    public RuoliNotificheFilter(
            @JsonProperty("id") String id,
            @JsonProperty("notificaId") String notificaId,
            @JsonProperty("ruoloId") String ruoloId,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.notificaId = notificaId;
        this.ruoloId = ruoloId;
        this.version = version;
    }
    public static RuoliNotificheFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        RuoliNotificheFilter filter = new RuoliNotificheFilter();
        if(map != null){
            filter.setId((String) map.get("id"));
            filter.setNotificaId((String) map.get("notificaId"));
            filter.setRuoloId((String) map.get("ruoloId"));
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

    public String getNotificaId() {
        return notificaId;
    }

    public void setNotificaId(String notificaId) {
        this.notificaId = notificaId;
    }

    public String getRuoloId() {
        return ruoloId;
    }

    public void setRuoloId(String ruoloId) {
        this.ruoloId = ruoloId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
