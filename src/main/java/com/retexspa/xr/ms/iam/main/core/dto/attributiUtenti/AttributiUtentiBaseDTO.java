package com.retexspa.xr.ms.iam.main.core.dto.attributiUtenti;

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
public class AttributiUtentiBaseDTO {

    @NotNull(message = "utenteApplicazioneId is mandatory")
    @NotEmpty(message = "utenteApplicazioneId is mandatory")
    @NotBlank(message = "utenteApplicazioneId is mandatory")
    private String utenteApplicazioneId;

    @NotNull(message = "attributoId is mandatory")
    @NotEmpty(message = "attributoId is mandatory")
    @NotBlank(message = "attributoId is mandatory")
    private String attributoId;

    @NotNull(message = "contestoId is mandatory")
    @NotEmpty(message = "contestoId is mandatory")
    @NotBlank(message = "contestoId is mandatory")
    private String contestoId;

    @NotNull(message = "valore is mandatory")
    @NotEmpty(message = "valore is mandatory")
    @NotBlank(message = "valore is mandatory")
    private String valore;

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

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public static String getAggregateName() {
        return "AttributiUtentiAggregate";
    }

    public static String getName() {
        return "AttributiUtenti";
    }
}
