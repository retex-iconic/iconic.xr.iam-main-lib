package com.retexspa.xr.ms.iam.main.core.dto.menu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuIndexDTO {
    private String menuId;

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
}
