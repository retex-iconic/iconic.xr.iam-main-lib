package com.retexspa.xr.ms.iam.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class AttributiUtentiQueryDTO {

    private String id;

    private String utenteApplicazioneId;

    private String attributoId;

    private String contestoId;

    private String valore;

    private Long version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUtenteApplicazioneId() {
        return utenteApplicazioneId;
    }

    public void setUtenteApplicazioneId(String utenteApplicazioneId) {
        this.utenteApplicazioneId = utenteApplicazioneId;
    }

    public String getAttributoId() {
        return attributoId;
    }

    public void setAttributoId(String attributoId) {
        this.attributoId = attributoId;
    }

    public String getContestoId() {
        return contestoId;
    }

    public void setContestoId(String contestoId) {
        this.contestoId = contestoId;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
