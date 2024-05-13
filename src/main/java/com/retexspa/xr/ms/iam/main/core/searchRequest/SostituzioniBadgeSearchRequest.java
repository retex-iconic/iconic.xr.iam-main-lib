package com.retexspa.xr.ms.iam.main.core.searchRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.BaseSortPagination;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class SostituzioniBadgeSearchRequest extends BaseSortPagination {
    private String id;
    private String utentiId;
    private String badgeId;
    private LocalDateTime dataAssegnazione;
    private LocalDateTime dataBlocco;
    private LocalDateTime dataSblocco;
    private LocalDateTime dataRiconsegna;
    private String causale;
    private String stato;
    private Long version;
    public SostituzioniBadgeSearchRequest(
            @JsonProperty("page") Integer page,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("sort") List<BaseSort> sort,
            @JsonProperty("id") String id,
            @JsonProperty("utentiId") String utentiId,
            @JsonProperty("badgeId") String badgeId,
            @JsonProperty("dataAssegnazione") LocalDateTime dataAssegnazione,
            @JsonProperty("dataBlocco") LocalDateTime dataBlocco,
            @JsonProperty("dataSblocco") LocalDateTime dataSblocco,
            @JsonProperty("dataRiconsegna") LocalDateTime dataRiconsegna,
            @JsonProperty("causale") String causale,
            @JsonProperty("stato") String stato,
            @JsonProperty("version") Long version) {
        super(page, limit, sort);
        this.id = id;
        this.utentiId = utentiId;
        this.badgeId = badgeId;
        this.dataAssegnazione = dataAssegnazione;
        this.dataBlocco = dataBlocco;
        this.dataSblocco = dataSblocco;
        this.dataRiconsegna = dataRiconsegna;
        this.causale = causale;
        this.stato = stato;
        this.version= version;
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

    public void setUtentiId(String utentiId) {
        this.utentiId = utentiId;
    }

    public String getBadgeId() {
        return badgeId;
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

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
