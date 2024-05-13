package com.retexspa.xr.ms.iam.main.core.dto.tipiContestoApplicazione;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TipiContestoApplicazioneBaseDTO {
    @NotNull(message = "tipiContestoId is mandatory")
    @NotEmpty(message = "tipiContestoId is mandatory")
    @NotBlank(message = "tipiContestoId is mandatory")
    private String tipiContestoId;
    @NotNull(message = "applicazioneId is mandatory")
    @NotEmpty(message = "applicazioneId is mandatory")
    @NotBlank(message = "applicazioneId is mandatory")
    private String applicazioneId;
    private String tassonomiaId;
    
    public String getApplicazioneId() {
        return applicazioneId;
    }

    public void setApplicazioneId(String applicazioneId) {
        this.applicazioneId = applicazioneId;
    }

    public String getTassonomiaId() {
        return tassonomiaId;
    }

    public void setTassonomiaId(String tassonomiaId) {
        this.tassonomiaId = tassonomiaId;
    }

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public String getTipiContestoId() {
        return tipiContestoId;
    }

    public void setTipiContestoId(String tipiContestoId) {
        this.tipiContestoId = tipiContestoId;
    }
}
