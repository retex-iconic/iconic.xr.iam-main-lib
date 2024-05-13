package com.retexspa.xr.ms.iam.main.core.filterRequest;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnagAttributiUtentiFilter {
    private String id;
    private String nomeAttributo;

    private Integer posizione;

    private String tipo;

    private String formato;

    private String flgCifrato;

    private String flgUnico;

    private String flgObbligatorio ;

    private String defaultValue;

    private String checkFunction;

    private String tipoContestoApplicazioneId;

    private String shareTipoContestoApplicazioneId;

    private Long version;

    public AnagAttributiUtentiFilter() {
    }

    public AnagAttributiUtentiFilter(
            @JsonProperty("id") String id,
            @JsonProperty("nomeAttributo") String nomeAttributo,
            @JsonProperty("posizione") Integer posizione,
            @JsonProperty("tipo") String tipo,
            @JsonProperty("formato") String formato,
            @JsonProperty("flgCifrato") String flgCifrato,
            @JsonProperty("flgUnico") String flgUnico,
            @JsonProperty("flgObbligatorio") String flgObbligatorio,
            @JsonProperty("defaultValue") String defaultValue,
            @JsonProperty("checkFunction") String checkFunction,
            @JsonProperty("tipoContestoApplicazioneId") String tipoContestoApplicazioneId,
            @JsonProperty("shareTipoContestoApplicazioneId") String shareTipoContestoApplicazioneId,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.nomeAttributo = nomeAttributo;
        this.posizione = posizione;
        this.tipo = tipo;
        this.formato = formato;
        this.flgCifrato = flgCifrato;
        this.flgUnico = flgUnico;
        this.flgObbligatorio = flgObbligatorio;
        this.defaultValue = defaultValue;
        this.checkFunction = checkFunction;
        this.tipoContestoApplicazioneId = tipoContestoApplicazioneId;
        this.shareTipoContestoApplicazioneId = shareTipoContestoApplicazioneId;
        this.version = version;
    }

    public static AnagAttributiUtentiFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        AnagAttributiUtentiFilter filter = new AnagAttributiUtentiFilter();
        if (map != null) {
            filter.setId((String) map.get("id"));
            filter.setNomeAttributo((String) map.get("nomeAttributo"));
            filter.setPosizione((Integer) map.get("posizione"));
            filter.setTipo((String) map.get("tipo"));
            filter.setFormato((String) map.get("formato"));
            filter.setFlgCifrato((String) map.get("flgCifrato"));
            filter.setFlgUnico((String) map.get("flgUnico"));
            filter.setFlgObbligatorio((String) map.get("flgObbligatorio"));
            filter.setDefaultValue((String) map.get("defaultValue"));
            filter.setCheckFunction((String) map.get("checkFunction"));
            filter.setTipoContestoApplicazioneId((String) map.get("tipoContestoApplicazioneId"));
            filter.setShareTipoContestoApplicazioneId((String) map.get("shareTipoContestoApplicazioneId"));
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

    public String getNomeAttributo() {
        return nomeAttributo;
    }

    public void setNomeAttributo(String nomeAttributo) {
        this.nomeAttributo = nomeAttributo;
    }

    public Integer getPosizione() {
        return posizione;
    }

    public void setPosizione(Integer posizione) {
        this.posizione = posizione;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFlgCifrato() {
        return flgCifrato;
    }

    public void setFlgCifrato(String flgCifrato) {
        this.flgCifrato = flgCifrato;
    }

    public String getFlgUnico() {
        return flgUnico;
    }

    public void setFlgUnico(String flgUnico) {
        this.flgUnico = flgUnico;
    }

    public String getFlgObbligatorio() {
        return flgObbligatorio;
    }

    public void setFlgObbligatorio(String flgObbligatorio) {
        this.flgObbligatorio = flgObbligatorio;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getCheckFunction() {
        return checkFunction;
    }

    public void setCheckFunction(String checkFunction) {
        this.checkFunction = checkFunction;
    }

    public String getTipoContestoApplicazioneId() {
        return tipoContestoApplicazioneId;
    }

    public void setTipoContestoApplicazioneId(String tipoContestoApplicazioneId) {
        this.tipoContestoApplicazioneId = tipoContestoApplicazioneId;
    }

    public String getShareTipoContestoApplicazioneId() {
        return shareTipoContestoApplicazioneId;
    }

    public void setShareTipoContestoApplicazioneId(String shareTipoContestoApplicazioneId) {
        this.shareTipoContestoApplicazioneId = shareTipoContestoApplicazioneId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
