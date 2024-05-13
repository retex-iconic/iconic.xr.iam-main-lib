package com.retexspa.xr.ms.iam.main.core.dto.configUser;

public class ConfigUserDTO {

    private RoutingDTO routing;
    private MenuDTO menu;    

    public ConfigUserDTO(RoutingDTO routing, MenuDTO menu) {
        this.routing = routing;
        this.menu = menu;
    }
    
    public RoutingDTO getRouting() {
        return routing;
    }
    public void setRouting(RoutingDTO routing) {
        this.routing = routing;
    }
    public MenuDTO getMenu() {
        return menu;
    }
    public void setMenu(MenuDTO menu) {
        this.menu = menu;
    }
    
        
}
