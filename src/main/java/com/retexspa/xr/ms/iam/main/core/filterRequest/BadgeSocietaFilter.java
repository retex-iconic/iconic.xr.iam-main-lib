package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

public class BadgeSocietaFilter {

    private String id;
    private String codiceBadge;
    private String pwd;
    private String societaId;
    private String gerarchiaId;
    private String tipoBadge;
    private Long version;

    public BadgeSocietaFilter() {}

    public BadgeSocietaFilter(
            @JsonProperty("id") String id,
            @JsonProperty("codiceBadge") String codiceBadge,
            @JsonProperty("pwd") String pwd,
            @JsonProperty("societaId") String societaId,
            @JsonProperty("gerarchiaId") String gerarchiaId,
            @JsonProperty("tipoBadge") String tipoBadge,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.codiceBadge = codiceBadge;
        this.pwd = pwd;
        this.societaId = societaId;
        this.gerarchiaId = gerarchiaId;
        this.tipoBadge = tipoBadge;
        this.version = version;
    }

    public static BadgeSocietaFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        BadgeSocietaFilter filter = new BadgeSocietaFilter();
        if (map != null) {
            filter.setId((String) map.get("id"));
            filter.setCodiceBadge((String) map.get("codiceBadge"));
            filter.setPwd((String) map.get("pwd"));
            filter.setTipoBadge((String) map.get("tipoBadge"));
            filter.setSocietaId((String) map.get("societaId"));
            filter.setGerarchiaId((String) map.get("gerarchiaId"));
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

    public String getCodiceBadge() {
        return codiceBadge;
    }

    public void setCodiceBadge(String codiceBadge) {
        this.codiceBadge = codiceBadge;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSocietaId() {
        return societaId;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
    }

    public String getGerarchiaId() {
        return gerarchiaId;
    }

    public void setGerarchiaId(String gerarchiaId) {
        this.gerarchiaId = gerarchiaId;
    }

    public String getTipoBadge() {
        return tipoBadge;
    }

    public void setTipoBadge(String tipoBadge) {
        this.tipoBadge = tipoBadge;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
