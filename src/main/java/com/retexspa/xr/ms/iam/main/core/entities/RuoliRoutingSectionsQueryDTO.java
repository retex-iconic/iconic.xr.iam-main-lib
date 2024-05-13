package com.retexspa.xr.ms.iam.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class RuoliRoutingSectionsQueryDTO {
    private String id;
    private String ruoliRoutingId;
    private String routingSectionId;
    private String flgAttiva;
    private String flgReadonly;
    private String flgInsert;
    private String flgUpdate;
    private String flgDelete;
    private Long version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
