package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

public class AttributiRuoliFilter {
    private String id;
    private String ruoloId;
    private String attributoruoloId;
    private String valore;
    private Long version;
    public AttributiRuoliFilter() {
    }
    public AttributiRuoliFilter(
            @JsonProperty("id") String id,
            @JsonProperty("ruoloId") String ruoloId,
            @JsonProperty("attributoruoloId") String attributoruoloId,
            @JsonProperty("valore") String valore,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.ruoloId = ruoloId;
        this.attributoruoloId = attributoruoloId;
        this.valore = valore;
        this.version = version;
    }
    public static AttributiRuoliFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        AttributiRuoliFilter filter = new AttributiRuoliFilter();
        if(map != null){
            filter.setId((String) map.get("id"));
            filter.setRuoloId((String) map.get("ruoloId"));
            filter.setAttributoruoloId((String) map.get("attributoruoloId"));
            filter.setValore((String) map.get("valore"));
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

    public String getRuoloId() {
        return ruoloId;
    }

    public void setRuoloId(String ruoloId) {
        this.ruoloId = ruoloId;
    }

    public String getAttributoruoloId() {
        return attributoruoloId;
    }

    public void setAttributoruoloId(String attributoruoloId) {
        this.attributoruoloId = attributoruoloId;
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
