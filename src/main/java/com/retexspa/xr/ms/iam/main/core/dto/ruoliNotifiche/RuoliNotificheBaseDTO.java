package com.retexspa.xr.ms.iam.main.core.dto.ruoliNotifiche;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RuoliNotificheBaseDTO {
    @NotNull(message = "notificaId is mandatory")
    @NotEmpty(message = "notificaId is mandatory")
    @NotBlank(message = "notificaId is mandatory")
    private String notificaId;
    @NotNull(message = "ruoloId is mandatory")
    @NotEmpty(message = "ruoloId is mandatory")
    @NotBlank(message = "ruoloId is mandatory")
    private String ruoloId;

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

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public static String getAggregateName() {
        return "RuoliNotificheAggregate";
    }

    public static String getName() {
        return "RuoliNotifiche";
    }
}
