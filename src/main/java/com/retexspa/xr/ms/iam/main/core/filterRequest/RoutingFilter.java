package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;

@Getter
@Setter
public class RoutingFilter {
    private String id;
    private String routingCharId;
    private String titolo;
    private String urlLink;
    private String icone;
    private String  subtitolo;
    private String iconicApplicazioniId;
    private String flgGdpr;
    private String nodoId;
    private Long version;

    public RoutingFilter() {
    }

    public RoutingFilter(
            @JsonProperty("id") String id,
            @JsonProperty("routingCharId") String routingCharId,
            @JsonProperty("titolo") String titolo,
            @JsonProperty("subtitolo") String subtitolo,
            @JsonProperty("urlLink") String urlLink,
            @JsonProperty("icone") String icone,
            @JsonProperty("iconicApplicazioniId") String iconicApplicazioniId,
            @JsonProperty("flgGdpr") String flgGdpr,
            @JsonProperty("nodoId") String nodoId,
            @JsonProperty("version") Long version
    ) {
        this.id = id;
        this.routingCharId = routingCharId;
        this.titolo = titolo;
        this.subtitolo = subtitolo;
        this.urlLink = urlLink;
        this.icone = icone;
        this.iconicApplicazioniId = iconicApplicazioniId;
        this.flgGdpr = flgGdpr;
        this.nodoId = nodoId;
        this.version = version;
    }
    public static RoutingFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        RoutingFilter filter = new RoutingFilter();
        if(map != null){
            filter.setId((String) map.get("id"));
            filter.setRoutingCharId((String) map.get("routingCharId"));
            filter.setTitolo((String) map.get("titolo"));
            filter.setUrlLink((String) map.get("urlLink"));
            filter.setIcone((String) map.get("icone"));
            filter.setSubtitolo((String) map.get("titolo"));
            filter.setIconicApplicazioniId((String) map.get("iconicApplicazioniId"));
            filter.setFlgGdpr((String) map.get("flgGdpr"));
            filter.setNodoId((String) map.get("nodoId"));
            filter.setNodoId((String) map.get("nodoId"));

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
