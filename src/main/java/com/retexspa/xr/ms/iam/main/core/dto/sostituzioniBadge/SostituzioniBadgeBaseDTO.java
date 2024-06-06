package com.retexspa.xr.ms.iam.main.core.dto.sostituzioniBadge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SostituzioniBadgeBaseDTO extends SostituzioniBadgeBaseRequestDTO{

    // calcolato
    private String stato;

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
    
    public static String getAggregateName() {
        return "SostituzioniBadgeAggregate";
    }

    public static String getName() {
        return "SostituzioniBadge";
    }
    

}
