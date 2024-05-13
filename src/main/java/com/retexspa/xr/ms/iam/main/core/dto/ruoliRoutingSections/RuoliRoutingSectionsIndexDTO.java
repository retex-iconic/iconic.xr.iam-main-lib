package com.retexspa.xr.ms.iam.main.core.dto.ruoliRoutingSections;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuoliRoutingSectionsIndexDTO {
    private String ruoliRoutingSectionsId;
    public RuoliRoutingSectionsIndexDTO(){}
    public RuoliRoutingSectionsIndexDTO(String ruoliRoutingSectionsId) {
        this.ruoliRoutingSectionsId = ruoliRoutingSectionsId;
    }
    public static String getIdFromRuoliRoutingSections(String ruoliRoutingSectionsId) {
        return UUID.nameUUIDFromBytes(("/RuoliRoutingSectionsIndex/" + ruoliRoutingSectionsId).getBytes()).toString();
    }

    public String getRuoliRoutingSectionsId() {
        return ruoliRoutingSectionsId;
    }

    public void setRuoliRoutingSectionsId(String ruoliRoutingSectionsId) {
        this.ruoliRoutingSectionsId = ruoliRoutingSectionsId;
    }
}
