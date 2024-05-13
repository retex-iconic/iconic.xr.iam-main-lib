package com.retexspa.xr.ms.iam.main.core.searchRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.BaseSortPagination;

import java.util.List;

public class TipiContestoApplicazioneSearchRequest extends BaseSortPagination {

    private String id;
    private String applicazioneId;
    private String tipiContestoId;
    private Long version;
    private String tassonomiaId;

    public TipiContestoApplicazioneSearchRequest(
            @JsonProperty("page") Integer page,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("sort") List<BaseSort> sort,
            @JsonProperty("id") String id,
            @JsonProperty("applicazioneId") String applicazioneId,
            @JsonProperty("tipiContestoId") String tipiContestoId,
            @JsonProperty("tassonomiaId") String tassonomiaId,
            @JsonProperty("version") Long version
    ) {
        super(page, limit, sort);
        this.id = id;
        this.applicazioneId = applicazioneId;
        this.tipiContestoId = tipiContestoId;
        this.version = version;
        this.tassonomiaId = tassonomiaId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicazioneId() {
        return applicazioneId;
    }

    public void setApplicazioneId(String applicazioneId) {
        this.applicazioneId = applicazioneId;
    }    

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTipiContestoId() {
        return tipiContestoId;
    }

    public void setTipiContestoId(String tipiContestoId) {
        this.tipiContestoId = tipiContestoId;
    }

    public String getTassonomiaId() {
        return tassonomiaId;
    }

    public void setTassonomiaId(String tassonomiaId) {
        this.tassonomiaId = tassonomiaId;
    }
}
