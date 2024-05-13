package com.retexspa.xr.ms.iam.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class RuoliNotificheQueryDTO {
    private String id;
    private String notificaId;
    private String ruoloId;
    private Long version;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotificaId() {
        return notificaId;
    }

    public void setNotificaId(String notificaId) {
        this.notificaId = notificaId;
    }

    public String getRuoloId() {
        return ruoloId;
    }

    public void setRuoloId(String ruoloId) {
        this.ruoloId = ruoloId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
