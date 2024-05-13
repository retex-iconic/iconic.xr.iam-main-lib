package com.retexspa.xr.ms.iam.main.core.dto.menu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MenuUpdateDTO {
    private String titolo;
    private Integer ordinamento;
    private String icone;
    private String queryParams;
    @EnumValidator(enumClazz = Enums.CheckSN.class , message = "flg_attiva not valid")
    private String flgAttiva;
    @EnumValidator(enumClazz = com.retexspa.xr.ms.iam.main.core.dto.Enums.CheckSN.class , message = "home_pagina not valid")
    private String homePagina;

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

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
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
}
