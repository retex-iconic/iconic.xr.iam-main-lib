package com.retexspa.xr.ms.iam.main.core.filterRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SostituzioniBadgeFilter {

    private String id;
    private String utentiId;
    private String badgeId;
    private String codiceBadge;
    private String tipoBadge;
    private LocalDateTime dataAssegnazione;
    private LocalDateTime dataBlocco;
    private LocalDateTime dataSblocco;
    private LocalDateTime dataRiconsegna;
    private String causale;
    private String stato;
    private Long version;

    public SostituzioniBadgeFilter(
            @JsonProperty("id") String id,
            @JsonProperty("utentiId") String utentiId,
            @JsonProperty("badgeId") String badgeId,
            @JsonProperty("codiceBadge") String codiceBadge,
            @JsonProperty("tipoBadge") String tipoBadge,
            @JsonProperty("dataAssegnazione") LocalDateTime dataAssegnazione,
            @JsonProperty("dataBlocco") LocalDateTime dataBlocco,
            @JsonProperty("dataSblocco") LocalDateTime dataSblocco,
            @JsonProperty("dataRiconsegna") LocalDateTime dataRiconsegna,
            @JsonProperty("causale") String causale,
            @JsonProperty("stato") String stato,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.utentiId = utentiId;
        this.badgeId = badgeId;
        this.codiceBadge = codiceBadge;
        this.tipoBadge = tipoBadge;
        this.dataAssegnazione = dataAssegnazione;
        this.dataBlocco = dataBlocco;
        this.dataSblocco = dataSblocco;
        this.dataRiconsegna = dataRiconsegna;
        this.causale = causale;
        this.stato = stato;
        this.version = version;
    }

    public SostituzioniBadgeFilter() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUtentiId() {
        return utentiId;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public void setUtentiId(String utentiId) {
        this.utentiId = utentiId;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public String getTipoBadge() {
        return tipoBadge;
    }

    public void setTipoBadge(String tipoBadge) {
        this.tipoBadge = tipoBadge;
    }

    public void setBadgeId(String badgeId) {
        this.badgeId = badgeId;
    }

    public LocalDateTime getDataAssegnazione() {
        return dataAssegnazione;
    }

    public void setDataAssegnazione(LocalDateTime dataAssegnazione) {
        this.dataAssegnazione = dataAssegnazione;
    }

    public LocalDateTime getDataBlocco() {
        return dataBlocco;
    }

    public void setDataBlocco(LocalDateTime dataBlocco) {
        this.dataBlocco = dataBlocco;
    }

    public LocalDateTime getDataSblocco() {
        return dataSblocco;
    }

    public void setDataSblocco(LocalDateTime dataSblocco) {
        this.dataSblocco = dataSblocco;
    }

    public LocalDateTime getDataRiconsegna() {
        return dataRiconsegna;
    }

    public void setDataRiconsegna(LocalDateTime dataRiconsegna) {
        this.dataRiconsegna = dataRiconsegna;
    }

    public String getCausale() {
        return causale;
    }

    public void setCausale(String causale) {
        this.causale = causale;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCodiceBadge() {
        return codiceBadge;
    }

    public void setCodiceBadge(String codiceBadge) {
        this.codiceBadge = codiceBadge;
    }

    public static SostituzioniBadgeFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        SostituzioniBadgeFilter filter = new SostituzioniBadgeFilter();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        if (map != null) {
            filter.setId((String) map.get("id"));
            filter.setUtentiId((String) map.get("utentiId"));
            filter.setBadgeId((String) map.get("badgeId"));
            filter.setCodiceBadge((String) map.get("codiceBadge"));
            filter.setTipoBadge((String) map.get("tipoBadge"));

            Object dataAssegnazione = map.get("dataAssegnazione");
            if (dataAssegnazione != null) {
                LocalDateTime data = parseDate(dataAssegnazione, map, formatter);
                if (data != null) {
                    filter.setDataAssegnazione(data.truncatedTo(ChronoUnit.DAYS));
                }
            }

            Object dataBlocco = map.get("dataBlocco");
            if (dataBlocco != null) {
                LocalDateTime data = parseDate(dataBlocco, map, formatter);
                if (data != null) {
                    filter.setDataBlocco(data.truncatedTo(ChronoUnit.DAYS));
                }
            }

            Object dataSblocco = map.get("dataSblocco");
            if (dataSblocco != null) {
                LocalDateTime data = parseDate(dataSblocco, map, formatter);
                if (data != null) {
                    filter.setDataSblocco(data.truncatedTo(ChronoUnit.DAYS));
                }
            }

            Object dataRiconsegna = map.get("dataRiconsegna");
            if (dataRiconsegna != null) {
                LocalDateTime data = parseDate(dataRiconsegna, map, formatter);
                if (data != null) {
                    filter.setDataRiconsegna(data.truncatedTo(ChronoUnit.DAYS));
                }
            }

            filter.setCausale((String) map.get("causale"));
            filter.setStato((String) map.get("stato"));

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

    static LocalDateTime parseDate(
            Object date,
            LinkedHashMap<String, Object> map,
            DateTimeFormatter formatter) {
        LocalDateTime data = null;
        if (date instanceof String) {
            data = LocalDateTime.parse((String) date, formatter);
        } else if (date instanceof LocalDateTime) {
            data = (LocalDateTime) date;
        }
        return data;
    }

}
