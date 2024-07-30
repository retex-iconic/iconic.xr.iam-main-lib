package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

public class UtentiApplicazioniFilter {

    private String id;
    private String utenteId;
    private String idAccount;
    private String contestoId;
    private String ruoloId;
    private String applicazioneId;
    private String societaId;
    private LocalDateTime dataInizioValidita;
    private LocalDateTime dataFineValidita;
    @EnumValidator(enumClazz = Enums.CheckSN.class)
    private String flgAcquisizioneAuto;
    private Long version;

    public UtentiApplicazioniFilter() {
    }

    public UtentiApplicazioniFilter(
            @JsonProperty("id") String id,
            @JsonProperty("utenteId") String utenteId,
            @JsonProperty("idAccount") String idAccount,
            @JsonProperty("contestoId") String contestoId,
            @JsonProperty("ruoloId") String ruoloId,
            @JsonProperty("applicazioneId") String applicazioneId, 
            @JsonProperty("societaId") String societaId, 
            @JsonProperty("dataInizioValidita") LocalDateTime dataInizioValidita,
            @JsonProperty("dataFineValidita") LocalDateTime dataFineValidita,
            @JsonProperty("flgAcquisizioneAuto") String flgAcquisizioneAuto,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.utenteId = utenteId;
        this.idAccount = idAccount;
        this.contestoId = contestoId;
        this.ruoloId = ruoloId;
        this.applicazioneId = applicazioneId;
        this.societaId = societaId;
        this.dataInizioValidita = dataInizioValidita;
        this.dataFineValidita = dataFineValidita;
        this.flgAcquisizioneAuto = flgAcquisizioneAuto;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUtenteId() {
        return utenteId;
    }

    public void setUtenteId(String utenteId) {
        this.utenteId = utenteId;
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

    public LocalDateTime getDataInizioValidita() {
        return dataInizioValidita;
    }

    public void setDataInizioValidita(LocalDateTime dataInizioValidita) {
        this.dataInizioValidita = dataInizioValidita;
    }

    public LocalDateTime getDataFineValidita() {
        return dataFineValidita;
    }

    public void setDataFineValidita(LocalDateTime dataFineValidita) {
        this.dataFineValidita = dataFineValidita;
    }

    public String getFlgAcquisizioneAuto() {
        return flgAcquisizioneAuto;
    }

    public void setFlgAcquisizioneAuto(String flgAcquisizioneAuto) {
        this.flgAcquisizioneAuto = flgAcquisizioneAuto;
    }

    public String getSocietaId() {
        return societaId;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
    }

    public static UtentiApplicazioniFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        UtentiApplicazioniFilter filter = new UtentiApplicazioniFilter();
        if (map != null) {
            filter.setId((String) map.get("id"));
            filter.setUtenteId((String) map.get("utenteId"));
            filter.setIdAccount((String) map.get("idAccount"));
            filter.setContestoId((String) map.get("contestoId"));
            filter.setRuoloId((String) map.get("ruoloId"));
            filter.setApplicazioneId((String) map.get("applicazioneId"));
            filter.setSocietaId((String) map.get("societaId"));
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            Object dataInizioValidita = map.get("dataInizioValidita");
            if (dataInizioValidita != null) {
                if(dataInizioValidita instanceof String){
                    filter.setDataInizioValidita(LocalDateTime.parse((String) map.get("dataInizioValidita"), formatter));
                } else if (dataInizioValidita instanceof LocalDateTime){
                    filter.setDataInizioValidita((LocalDateTime) dataInizioValidita);
                }
            }
            Object dataFineValidita = map.get("dataFineValidita");
            if (dataFineValidita != null) {
                if(dataFineValidita instanceof String){
                    filter.setDataFineValidita(LocalDateTime.parse((String) map.get("dataFineValidita"), formatter));
                } else if (dataFineValidita instanceof LocalDateTime){
                    filter.setDataFineValidita((LocalDateTime) dataFineValidita);
                }
            }
            filter.setFlgAcquisizioneAuto((String) map.get("flgAcquisizioneAuto"));
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getApplicazioneId() {
        return applicazioneId;
    }

    public void setApplicazioneId(String applicazioneId) {
        this.applicazioneId = applicazioneId;
    }

}
