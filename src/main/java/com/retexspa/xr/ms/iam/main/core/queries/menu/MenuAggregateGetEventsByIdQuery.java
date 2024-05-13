package com.retexspa.xr.ms.iam.main.core.queries.menu;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuAggregateGetEventsByIdQuery {
    private String menuId;

    public MenuAggregateGetEventsByIdQuery(@JsonProperty("menuId") String menuId) {
        this.menuId = menuId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
