package com.retexspa.xr.ms.iam.main.core.filterRequest;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GestioneRuoliApplicazioniFilter {

    private String utenteSocietaId;
    private String applicazioneId;

    public GestioneRuoliApplicazioniFilter() {
    }    

    public GestioneRuoliApplicazioniFilter(@JsonProperty("utenteSocietaId") String utenteSocietaId,
            @JsonProperty("applicazioneId") String applicazioneId) {
        this.utenteSocietaId = utenteSocietaId;
        this.applicazioneId = applicazioneId;
    }

    public String getUtenteSocietaId() {
        return utenteSocietaId;
    }

    public String getApplicazioneId() {
        return applicazioneId;
    }

    public void setApplicazioneId(String applicazioneId) {
        this.applicazioneId = applicazioneId;
    }

    public void setUtenteSocietaId(String utenteSocietaId) {
        this.utenteSocietaId = utenteSocietaId;
    }

    public static GestioneRuoliApplicazioniFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        GestioneRuoliApplicazioniFilter filter = new GestioneRuoliApplicazioniFilter();
        if (map != null) {
            filter.setUtenteSocietaId((String) map.get("utenteSocietaId"));
            filter.setApplicazioneId((String) map.get("applicazioneId"));
        }
        return filter;
    }

}

