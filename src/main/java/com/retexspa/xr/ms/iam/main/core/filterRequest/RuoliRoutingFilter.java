package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

public class RuoliRoutingFilter {
    private String id;
    private String routingId;
    private String ruoloId;
    private String flgAttiva;
    private String flgReadonly;
    private String flgInsert;
    private String flgUpdate;
    private String flgDelete;
    private Long version;

    public RuoliRoutingFilter() {
    }

    public RuoliRoutingFilter(
            @JsonProperty("id") String id,
            @JsonProperty("routingId") String routingId,
            @JsonProperty("ruoloId") String ruoloId,
            @JsonProperty("flgAttiva") String flgAttiva,
            @JsonProperty("flgReadonly") String flgReadonly,
            @JsonProperty("flgInsert") String flgInsert,
            @JsonProperty("flgUpdate") String flgUpdate,
            @JsonProperty("flgDelete") String flgDelete,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.routingId = routingId;
        this.ruoloId = ruoloId;
        this.flgAttiva = flgAttiva;
        this.flgReadonly = flgReadonly;
        this.flgInsert = flgInsert;
        this.flgUpdate = flgUpdate;
        this.flgDelete = flgDelete;
        this.version = version;
    }
    public static RuoliRoutingFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        RuoliRoutingFilter filter = new RuoliRoutingFilter();
        if(map != null){
            filter.setId((String) map.get("id"));
            filter.setRoutingId((String) map.get("routingId"));
            filter.setRuoloId((String) map.get("ruoloId"));
            filter.setFlgAttiva((String) map.get("flgAttiva"));
            filter.setFlgReadonly((String) map.get("flgReadonly"));
            filter.setFlgInsert((String) map.get("flgInsert"));
            filter.setFlgUpdate((String) map.get("flgUpdate"));
            filter.setFlgDelete((String) map.get("flgDelete"));

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

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

    public String getRuoloId() {
        return ruoloId;
    }

    public void setRuoloId(String ruoloId) {
        this.ruoloId = ruoloId;
    }

    public String getFlgAttiva() {
        return flgAttiva;
    }

    public void setFlgAttiva(String flgAttiva) {
        this.flgAttiva = flgAttiva;
    }

    public String getFlgReadonly() {
        return flgReadonly;
    }

    public void setFlgReadonly(String flgReadonly) {
        this.flgReadonly = flgReadonly;
    }

    public String getFlgInsert() {
        return flgInsert;
    }

    public void setFlgInsert(String flgInsert) {
        this.flgInsert = flgInsert;
    }

    public String getFlgUpdate() {
        return flgUpdate;
    }

    public void setFlgUpdate(String flgUpdate) {
        this.flgUpdate = flgUpdate;
    }

    public String getFlgDelete() {
        return flgDelete;
    }

    public void setFlgDelete(String flgDelete) {
        this.flgDelete = flgDelete;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
