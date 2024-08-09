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
    SostituzioniBadgeBaseDTO newSostituzioniBadge;

    //non mandatory
    String updateSostituzioniBadgeId;
    SostituzioniBadgeUpdateDTO updateSostituzioniBadge;
    
    //non mandatory ma devono essere presenti entrambi
    String utenteSocietaId; 
    String statoBadgePersonale;

    public SostituzioniBadgeBaseDTO getNewSostituzioniBadge() {
        return newSostituzioniBadge;
    }
    public void setNewSostituzioniBadge(SostituzioniBadgeBaseDTO sostituzioniBadge) {
        this.newSostituzioniBadge = sostituzioniBadge;
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
    public String getUpdateSostituzioniBadgeId() {
        return updateSostituzioniBadgeId;
    }
    public void setUpdateSostituzioniBadgeId(String updateSostituzioniBadgeId) {
        this.updateSostituzioniBadgeId = updateSostituzioniBadgeId;
    }
    public SostituzioniBadgeUpdateDTO getUpdateSostituzioniBadge() {
        return updateSostituzioniBadge;
    }
    public void setUpdateSostituzioniBadge(SostituzioniBadgeUpdateDTO updateSostituzioniBadge) {
        this.updateSostituzioniBadge = updateSostituzioniBadge;
    }

    


    
}
