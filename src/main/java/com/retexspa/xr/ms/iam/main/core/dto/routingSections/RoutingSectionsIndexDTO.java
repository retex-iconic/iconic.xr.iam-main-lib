package com.retexspa.xr.ms.iam.main.core.dto.routingSections;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoutingSectionsIndexDTO {

    private String routingSectionsId;

    public RoutingSectionsIndexDTO() {
    }

    public RoutingSectionsIndexDTO(String routingSectionsId) {
        this.routingSectionsId = routingSectionsId;
    }

    public static String getIdFromRoutingSections(String routingSectionsId) {
        return UUID.nameUUIDFromBytes(("/RoutingSectionsIndex/" + routingSectionsId).getBytes()).toString();
    }

    public String getRoutingSectionsId() {
        return routingSectionsId;
    }

    public void setRoutingSectionsId(String routingSectionsId) {
        this.routingSectionsId = routingSectionsId;
    }

}
