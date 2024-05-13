package com.retexspa.xr.ms.iam.main.core.dto.menu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuIndexDTO {
    private String menuId;
    private LinkedList<String> nodoIds;

    public MenuIndexDTO() {
    }

    public MenuIndexDTO(String menuId) {
        this.menuId = menuId;
    }

    public static String getIdFromMenu(String menuId) {
        return UUID.nameUUIDFromBytes(("/MenuIndex/" + menuId).getBytes()).toString();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public LinkedList<String> getNodoIds() {
        return nodoIds;
    }

    public void setNodoIds(LinkedList<String> nodoIds) {
        this.nodoIds = nodoIds;
    }

    public static String getDetailNameNodo() {
        return "nodoIds";
    }

}
