package com.retexspa.xr.ms.iam.main.core.dto.sostituzioniBadge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SostituzioniBadgeUpdateDTO extends SostituzioniBadgeUpdateRequestDTO{

    @JsonProperty("stato")
    private String stato;
    
    public String getStato() {
        return stato;
    }
    public void setStato(String stato) {
        this.stato = stato;
    }

    
}
