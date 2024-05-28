package com.retexspa.xr.ms.iam.main.core.dto.badgeSocieta;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BadgeSocietaBaseDTO {

    private String codiceBadge;

    @NotNull(message = "pwd is mandatory")
    @NotEmpty(message = "pwd is mandatory")
    @NotBlank(message = "pwd is mandatory")
    private String pwd;

    @NotNull(message = "societa is mandatory")
    @NotEmpty(message = "societa is mandatory")
    @NotBlank(message = "societa is mandatory")
    private String societaId;

    @NotNull(message = "tipoBadge is mandatory")
    @NotEmpty(message = "tipoBadge is mandatory")
    @NotBlank(message = "tipoBadge is mandatory")
    @EnumValidator(enumClazz = Enums.TipoBadge.class)
    private String tipoBadge;

    public String getCodiceBadge() {
        return codiceBadge;
    }

    public void setCodiceBadge(String codiceBadge) {
        this.codiceBadge = codiceBadge;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public static String getName(){
        return "BadgeSocieta";
    }

    public static String getAggregateName(){
        return "BadgeSocietaAggregate";
    }
}
