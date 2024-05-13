package com.retexspa.xr.ms.iam.main.core.dto.routing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoutingIndexDTO {

    private String routingId;
    private LinkedList<String> menuIds;
    private LinkedList<String> ruoliRoutingIds;
    private LinkedList<String> notificheIds;
    private LinkedList<String> routingSectionIds;
    private LinkedList<String> nodoIds;

    public RoutingIndexDTO() {
    }

    public RoutingIndexDTO(String routingId) {
        this.routingId = routingId;
    }

    public static String getIdFromRouting(String routingId) {
        return UUID.nameUUIDFromBytes(("/RoutingIndex/" + routingId).getBytes()).toString();
    }

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

    public LinkedList<String> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(LinkedList<String> menuIds) {
        this.menuIds = menuIds;
    }

    public LinkedList<String> getRuoliRoutingIds() {
        return ruoliRoutingIds;
    }

    public void setRuoliRoutingIds(LinkedList<String> ruoliRoutingIds) {
        this.ruoliRoutingIds = ruoliRoutingIds;
    }

    public LinkedList<String> getNotificheIds() {
        return notificheIds;
    }

    public void setNotificheIds(LinkedList<String> notificheIds) {
        this.notificheIds = notificheIds;
    }

    public LinkedList<String> getRoutingSectionIds() {
        return routingSectionIds;
    }

    public void setRoutingSectionIds(LinkedList<String> routingSectionIds) {
        this.routingSectionIds = routingSectionIds;
    }

    public LinkedList<String> getNodoIds() {
        return nodoIds;
    }

    public void setNodoIds(LinkedList<String> nodoIds) {
        this.nodoIds = nodoIds;
    }

    public static String getDetailNameRuoliRouting() {
        return "ruoliRoutingIds";
    }

    public static String getDetailNameNotifiche() {
        return "notificheIds";
    }

    public static String getDetailNameRoutingSection() {
        return "routingSectionIds";
    }

    public static String getDetailNameNodo() {
        return "nodoIds";
    }
    

    public static String getDetailNameMenu() {
        return "menuIds";
    }



}
