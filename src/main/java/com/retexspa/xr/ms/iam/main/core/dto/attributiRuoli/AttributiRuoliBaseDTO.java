package com.retexspa.xr.ms.iam.main.core.dto.attributiRuoli;

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
public class AttributiRuoliBaseDTO {

    @NotNull(message = "ruoloId is mandatory")
    @NotEmpty(message = "ruoloId is mandatory")
    @NotBlank(message = "ruoloId is mandatory")
    private String ruoloId;
    @NotNull(message = "attributoruoloId is mandatory")
    @NotEmpty(message = "attributoruoloId is mandatory")
    @NotBlank(message = "attributoruoloId is mandatory")
    private String attributoruoloId;
    @NotNull(message = "valore is mandatory")
    @NotEmpty(message = "valore is mandatory")
    @NotBlank(message = "valore is mandatory")
    private String valore;

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public String getRuoloId() {
        return ruoloId;
    }

    public void setRuoloId(String ruoloId) {
        this.ruoloId = ruoloId;
    }

    public String getAttributoruoloId() {
        return attributoruoloId;
    }

    public void setAttributoruoloId(String attributoruoloId) {
        this.attributoruoloId = attributoruoloId;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public static String getAggregateName() {
        return "AttributiRuoliAggregate";
    }

    public static String getName() {
        return "AttributiRuoli";
    }
}
