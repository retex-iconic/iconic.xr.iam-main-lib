package com.retexspa.xr.ms.iam.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class TipiContestoApplicazioneQueryDTO {
    private String id;
    private String applicazioneId;
    private String tipiContestoId;
    private Long version;
    private String tassonomiaId;

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
