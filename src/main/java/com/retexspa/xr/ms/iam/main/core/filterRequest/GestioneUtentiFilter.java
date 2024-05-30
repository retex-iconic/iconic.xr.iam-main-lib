package com.retexspa.xr.ms.iam.main.core.filterRequest;

import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GestioneUtentiFilter {

    private String idAccount;
    private String societaId;
    private String applicazioneId;
    private String matricola;
    private String nominativo;
    private String codiceFiscale;
    private String codiceBadge;
    private List<String> ruoliId;
    private String contestoId;
    private String ruoloId;

    private String utentiSocietaId;

    public GestioneUtentiFilter() {
    }

    public GestioneUtentiFilter(
            @JsonProperty("idAccount") String idAccount,
            @JsonProperty("societaId") String societaId,
            @JsonProperty("applicazioneId") String applicazioneId,
            @JsonProperty("matricola") String matricola,
            @JsonProperty("nominativo") String nominativo,
            @JsonProperty("codiceFiscale") String codiceFiscale,
            @JsonProperty("codiceBadge") String codiceBadge,
            @JsonProperty("ruoloId") String ruoloId,
            @JsonProperty("contestoId") String contestoId,
            @JsonProperty("ruoliId") List<String> ruoliId,
            @JsonProperty("utentiSocietaId") String utentiSocietaId) {
        this.idAccount = idAccount;
        this.applicazioneId = applicazioneId;
        this.societaId = societaId;
        this.matricola = matricola;
        this.nominativo = nominativo;
        this.codiceFiscale = codiceFiscale;
        this.codiceBadge = codiceBadge;
        this.ruoliId = ruoliId;
        this.ruoloId = ruoloId;
        this.contestoId = contestoId;
        this.utentiSocietaId = utentiSocietaId;
    }

    public static GestioneUtentiFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        GestioneUtentiFilter filter = new GestioneUtentiFilter();
        if (map != null) {

            filter.setIdAccount((String) map.get("idAccount"));
            filter.setSocietaId((String) map.get("societaId"));
            filter.setApplicazioneId((String) map.get("applicazioneId"));
            filter.setMatricola((String) map.get("matricola"));
            filter.setNominativo((String) map.get("nominativo"));
            filter.setCodiceFiscale((String) map.get("codiceFiscale"));
            filter.setCodiceBadge((String) map.get("codiceBadge"));
            filter.setRuoliId((List<String>) map.get("ruoliId"));
            filter.setContestoId((String) map.get("contestoId"));
            filter.setRuoloId((String) map.get("ruoloId"));
            filter.setUtentiSocietaId((String) map.get("utentiSocietaId"));
        }
        return filter;
    }

    public String getSocietaId() {
        return societaId;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
    }

    public String getApplicazioneId() {
        return applicazioneId;
    }

    public void setApplicazioneId(String applicazioneId) {
        this.applicazioneId = applicazioneId;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getCodiceBadge() {
        return codiceBadge;
    }

    public void setCodiceBadge(String codiceBadge) {
        this.codiceBadge = codiceBadge;
    }

    public List<String> getRuoliId() {
        return ruoliId;
    }

    public void setRuoliId(List<String> ruoliId) {
        this.ruoliId = ruoliId;
    }

    public String getContestoId() {
        return contestoId;
    }

    public void setContestoId(String contestoId) {
        this.contestoId = contestoId;
    }

    public String getRuoloId() {
        return ruoloId;
    }

    public void setRuoloId(String ruoloId) {
        this.ruoloId = ruoloId;
    }

    public String getUtentiSocietaId() {
        return utentiSocietaId;
    }

    public void setUtentiSocietaId(String utentiSocietaId) {
        this.utentiSocietaId = utentiSocietaId;
    }

}
