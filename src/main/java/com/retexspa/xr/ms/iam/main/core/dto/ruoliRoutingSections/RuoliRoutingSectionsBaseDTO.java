package com.retexspa.xr.ms.iam.main.core.dto.ruoliRoutingSections;

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
public class RuoliRoutingSectionsBaseDTO {
    @NotNull(message = "ruoliRoutingId is mandatory")
    @NotEmpty(message = "ruoliRoutingId is mandatory")
    @NotBlank(message = "ruoliRoutingId is mandatory")
    private String ruoliRoutingId;

    @NotNull(message = "routingSectionId is mandatory")
    @NotEmpty(message = "routingSectionId is mandatory")
    @NotBlank(message = "routingSectionId is mandatory")
    private String routingSectionId;

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

    public String getRuoliRoutingId() {
        return ruoliRoutingId;
    }

    public void setRuoliRoutingId(String ruoliRoutingId) {
        this.ruoliRoutingId = ruoliRoutingId;
    }

    public String getRoutingSectionId() {
        return routingSectionId;
    }

    public void setRoutingSectionId(String routingSectionId) {
        this.routingSectionId = routingSectionId;
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

    public static String getAggregateName() {
        return "RuoliRoutingSectionsAggregate";
    }

    public static String getName() {
        return "RuoliRoutingSections";
    }
}

