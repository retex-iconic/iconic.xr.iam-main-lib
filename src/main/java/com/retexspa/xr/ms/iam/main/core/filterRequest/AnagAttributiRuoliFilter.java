package com.retexspa.xr.ms.iam.main.core.filterRequest;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

public class AnagAttributiRuoliFilter {
    private String id;
    private String nomeAttributo;
    private String applicazioneId;
    private String shareApplicazioneId;
    private String tipo;
    private String formato;
    private Integer posizione;
    @EnumValidator(enumClazz = Enums.CheckSN.class)
    private String flgCifrato;
    @EnumValidator(enumClazz = Enums.CheckSN.class)
    private String flgUnico;
    @EnumValidator(enumClazz = Enums.CheckSN.class)
    private String flgObbligatorio;
    private String defaultValue;
    private String checkFunction;
    private Long version;

    public AnagAttributiRuoliFilter() {
    }

    public AnagAttributiRuoliFilter(
            @JsonProperty("id") String id,
            @JsonProperty("nomeAttributo") String nomeAttributo,
            @JsonProperty("applicazioneId") String applicazioneId,
            @JsonProperty("shareApplicazioneId") String shareApplicazioneId,
            @JsonProperty("tipo") String tipo,
            @JsonProperty("formato") String formato,
            @JsonProperty("posizione") Integer posizione,
            @JsonProperty("flgCifrato") String flgCifrato,
            @JsonProperty("flgUnico") String flgUnico,
            @JsonProperty("flgObbligatorio") String flgObbligatorio,
            @JsonProperty("defaultValue") String defaultValue,
            @JsonProperty("checkFunction") String checkFunction,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.nomeAttributo = nomeAttributo;
        this.applicazioneId = applicazioneId;
        this.shareApplicazioneId = shareApplicazioneId;
        this.tipo = tipo;
        this.formato = formato;
        this.posizione = posizione;
        this.flgCifrato = flgCifrato;
        this.flgUnico = flgUnico;
        this.flgObbligatorio = flgObbligatorio;
        this.defaultValue = defaultValue;
        this.checkFunction = checkFunction;
        this.version = version;
    }

    public static AnagAttributiRuoliFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        AnagAttributiRuoliFilter filter = new AnagAttributiRuoliFilter();
        if (map != null) {
            filter.setId((String) map.get("id"));
            filter.setNomeAttributo((String) map.get("nomeAttributo"));
            filter.setApplicazioneId((String) map.get("applicazioneId"));
            filter.setShareApplicazioneId((String) map.get("shareApplicazioneId"));
            filter.setTipo((String) map.get("tipo"));
            filter.setFormato((String) map.get("formato"));
            filter.setPosizione((Integer) map.get("posizione"));
            filter.setFlgCifrato((String) map.get("flgCifrato"));
            filter.setFlgUnico((String) map.get("flgUnico"));
            filter.setFlgObbligatorio((String) map.get("flgObbligatorio"));
            filter.setDefaultValue((String) map.get("defaultValue"));
            filter.setCheckFunction((String) map.get("checkFunction"));
            Object version = map.get("version");
            if (version != null) {
                if (version instanceof Integer) {
                    filter.setVersion(Long.valueOf((Integer) version));
                } else if (version instanceof Long) {
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

    public String getApplicazioneId() {
        return applicazioneId;
    }

    public void setApplicazioneId(String applicazioneId) {
        this.applicazioneId = applicazioneId;
    }

    public String getShareApplicazioneId() {
        return shareApplicazioneId;
    }

    public void setShareApplicazioneId(String shareApplicazioneId) {
        this.shareApplicazioneId = shareApplicazioneId;
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

    public Integer getPosizione() {
        return posizione;
    }

    public void setPosizione(Integer posizione) {
        this.posizione = posizione;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
