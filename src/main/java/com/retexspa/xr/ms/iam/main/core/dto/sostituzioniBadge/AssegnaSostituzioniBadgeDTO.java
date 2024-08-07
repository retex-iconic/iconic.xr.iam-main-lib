package com.retexspa.xr.ms.iam.main.core.dto.sostituzioniBadge;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AssegnaSostituzioniBadgeDTO {

    @NotNull(message = "Sostituzioni Badge is mandatory")
    SostituzioniBadgeBaseDTO sostituzioniBadge;
    @NotNull(message = "Utenti Societa Id is mandatory")
    @NotEmpty(message = "Utenti Societa Id is mandatory")
    @NotBlank(message = "Utenti Societa Id is mandatory")
    String utenteSocietaId;
    @NotNull(message = "Stato Badge Personale is mandatory")
    @NotEmpty(message = "Stato Badge Personale is mandatory")
    @NotBlank(message = "Stato Badge Personale is mandatory")
    String statoBadgePersonale;
    public SostituzioniBadgeBaseDTO getSostituzioniBadge() {
        return sostituzioniBadge;
    }
    public void setSostituzioniBadge(SostituzioniBadgeBaseDTO sostituzioniBadge) {
        this.sostituzioniBadge = sostituzioniBadge;
    }
    public String getUtenteSocietaId() {
        return utenteSocietaId;
    }
    public void setUtenteSocietaId(String utenteSocietaId) {
        this.utenteSocietaId = utenteSocietaId;
    }
    public String getStatoBadgePersonale() {
        return statoBadgePersonale;
    }
    public void setStatoBadgePersonale(String statoBadgePersonale) {
        this.statoBadgePersonale = statoBadgePersonale;
    }

    


    
}
