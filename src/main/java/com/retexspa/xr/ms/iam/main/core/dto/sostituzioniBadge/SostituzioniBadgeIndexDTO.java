package com.retexspa.xr.ms.iam.main.core.dto.sostituzioniBadge;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SostituzioniBadgeIndexDTO {
    private String sostituzioniBadgeId;
    
    private String societaId;
    @EnumValidator(enumClazz = Enums.TipoBadge.class)
    private String tipoBadge;
    private String utenteSocietaId;

    public SostituzioniBadgeIndexDTO() {
    }

    public void setSostituzioniBadgeId(String sostituzioniBadgeId) {
        this.sostituzioniBadgeId = sostituzioniBadgeId;
    }

    public SostituzioniBadgeIndexDTO(String sostituzioniBadgeId, String societaId, String tipoBadge,
            String utenteSocietaId) {
        this.sostituzioniBadgeId = sostituzioniBadgeId;
        this.societaId = societaId;
        this.tipoBadge = tipoBadge;
        this.utenteSocietaId = utenteSocietaId;
    }

    public static String getIdFromSostituzioniBadge(String sostituzioniBadgeId) {
        return UUID.nameUUIDFromBytes(("/SostituzioniBadgeIndex/" + sostituzioniBadgeId).getBytes()).toString();
    }

    public String getSostituzioniBadgeId() {
        return sostituzioniBadgeId;
    }

    public String getSocietaId() {
        return societaId;
    }

    public void setSocietaId(String societaId) {
        this.societaId = societaId;
    }

    public String getTipoBadge() {
        return tipoBadge;
    }

    public void setTipoBadge(String tipoBadge) {
        this.tipoBadge = tipoBadge;
    }

    public String getUtenteSocietaId() {
        return utenteSocietaId;
    }

    public void setUtenteSocietaId(String utenteSocietaId) {
        this.utenteSocietaId = utenteSocietaId;
    }

}
