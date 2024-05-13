package com.retexspa.xr.ms.iam.main.core.dto.routingSections;

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
public class RoutingSectionsBaseDTO {
    @NotNull(message = "routingId is mandatory")
    @NotEmpty(message = "routingId is mandatory")
    @NotBlank(message = "routingId is mandatory")
    private String routingId;
    @NotNull(message = "codice is mandatory")
    @NotEmpty(message = "codice is mandatory")
    @NotBlank(message = "codice is mandatory")
    private String codice;
    @NotNull(message = "descrizione is mandatory")
    private String descrizione;

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }
}
