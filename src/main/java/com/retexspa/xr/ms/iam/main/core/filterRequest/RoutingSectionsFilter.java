package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;

@Getter
@Setter
public class RoutingSectionsFilter {
    private String id;
    private String codice;
    private String descrizione;
    private String routingId;
    private Long version;

    public RoutingSectionsFilter() {
    }
    public RoutingSectionsFilter(
            @JsonProperty("id") String id,
            @JsonProperty("codice") String codice,
            @JsonProperty("descrizione") String descrizione,
            @JsonProperty("routingId") String routingId,
            @JsonProperty("version") Long version
    ) {
        this.id = id;
        this.codice = codice;
        this.descrizione = descrizione;
        this.routingId = routingId;
        this.version = version;
    }
    public static RoutingSectionsFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        RoutingSectionsFilter filter = new RoutingSectionsFilter();
        if(map != null){
            filter.setId((String) map.get("id"));
            filter.setCodice((String) map.get("codice"));
            filter.setDescrizione((String) map.get("descrizione"));
            filter.setRoutingId((String) map.get("routingId"));
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
}
