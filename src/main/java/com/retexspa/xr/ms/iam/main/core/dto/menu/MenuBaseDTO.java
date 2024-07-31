package com.retexspa.xr.ms.iam.main.core.dto.menu;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MenuBaseDTO {
    @NotNull(message = "menuCharId is mandatory")
    private String menuCharId;
    @NotNull(message = "titolo is mandatory")
    private String titolo;
    @NotNull(message = "routingId is mandatory")
    @NotEmpty(message = "routingId is mandatory")
    @NotBlank(message = "routingId is mandatory")
    private String routingId;
    @NotNull(message = "ordinamento is mandatory")
    private Integer ordinamento;
    private String icone;
    private String queryParams;
    @EnumValidator(enumClazz = Enums.CheckSN.class , message = "flg_attiva not valid")
    private String flgAttiva;
    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.CheckSN.class , message = "home_pagina not valid")
    private String homePagina;
    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.tipoMenu.class , message = "tipo_menu not valid")
    @NotNull(message = "tipoMenu is mandatory")
    private String tipoMenu;
    @NotNull(message = "id Menu is mandatory")
    private Integer idMenu;
    @JsonIgnore
    private Integer pidMenu;
    private String nodoId;
    @NotNull(message = "menuName is mandatory")
    private String menuName;
    @EnumValidator(enumClazz = Enums.CheckSN.class , message = "Menu Default not valid")
    private String menuDefault;
   

    public String getMenuCharId() {
        return menuCharId;
    }

    public void setMenuCharId(String menuCharId) {
        this.menuCharId = menuCharId;
    }

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

    public Integer getOrdinamento() {
        return ordinamento;
    }

    public void setOrdinamento(Integer ordinamento) {
        this.ordinamento = ordinamento;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }   

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getFlgAttiva() {
        return flgAttiva;
    }

    public void setFlgAttiva(String flgAttiva) {
        this.flgAttiva = flgAttiva;
    }

    public String getHomePagina() {
        return homePagina;
    }

    public void setHomePagina(String homePagina) {
        this.homePagina = homePagina;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public String getNodoId() {
        return nodoId;
    }

    public void setNodoId(String nodoId) {
        this.nodoId = nodoId;
    }
    

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getPidMenu() {
        return pidMenu;
    }

    public void setPidMenu(Integer pidMenu) {
        this.pidMenu = pidMenu;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }

    public static String getAggregateName() {
        return "MenuAggregate";
    }

    public static String getName() {
        return "Menu";
    }

    public static String getNameNodo() {
        return "MenuNodo";
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDefault() {
        return menuDefault;
    }

    public void setMenuDefault(String menuDefault) {
        this.menuDefault = menuDefault;
    }
    
}
