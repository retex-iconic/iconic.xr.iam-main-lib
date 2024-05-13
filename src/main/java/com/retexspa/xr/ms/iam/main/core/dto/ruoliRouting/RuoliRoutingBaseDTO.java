package com.retexspa.xr.ms.iam.main.core.dto.ruoliRouting;

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
public class RuoliRoutingBaseDTO {
    @NotNull(message = "routingId is mandatory")
    @NotEmpty(message = "routingId is mandatory")
    @NotBlank(message = "routingId is mandatory")
    private String routingId;

    @NotNull(message = "ruoloId is mandatory")
    @NotEmpty(message = "ruoloId is mandatory")
    @NotBlank(message = "ruoloId is mandatory")
    private String ruoloId;

    @EnumValidator(enumClazz = Enums.CheckSN.class , message = "flg_attiva not valid")
    private String flgAttiva;

    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.CheckSN.class , message = "flg_readonly not valid")
    private String flgReadonly;

    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.CheckSN.class , message = "flg_insert not valid")
    private String flgInsert;

    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.CheckSN.class , message = "flg_update not valid")
    private String flgUpdate;

    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.CheckSN.class , message = "flg_delete not valid")
    private String flgDelete;

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

    public String getRuoloId() {
        return ruoloId;
    }

    public void setRuoloId(String ruoloId) {
        this.ruoloId = ruoloId;
    }

    public String getFlgAttiva() {
        return flgAttiva;
    }

    public void setFlgAttiva(String flgAttiva) {
        this.flgAttiva = flgAttiva;
    }

    public String getFlgReadonly() {
        return flgReadonly;
    }

    public void setFlgReadonly(String flgReadonly) {
        this.flgReadonly = flgReadonly;
    }

    public String getFlgInsert() {
        return flgInsert;
    }

    public void setFlgInsert(String flgInsert) {
        this.flgInsert = flgInsert;
    }

    public String getFlgUpdate() {
        return flgUpdate;
    }

    public void setFlgUpdate(String flgUpdate) {
        this.flgUpdate = flgUpdate;
    }

    public String getFlgDelete() {
        return flgDelete;
    }

    public void setFlgDelete(String flgDelete) {
        this.flgDelete = flgDelete;
    }

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }
}
