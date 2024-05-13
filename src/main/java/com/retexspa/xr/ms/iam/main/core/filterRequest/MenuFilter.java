package com.retexspa.xr.ms.iam.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedHashMap;

public class MenuFilter {
    private String id;
    private String menuCharId;
    private String routingId;
    private Integer ordinamento;
    private String icone;
    private String titolo;
    private String flgAttiva;
    private String homePagina;
    private String tipoMenu;
    private String idMenu;
    private String pidMenu;
    private String queryParams;
    private String nodoId;
    private Long version;

    public MenuFilter() {
    }

    public MenuFilter(
            @JsonProperty("id") String id,
            @JsonProperty("menuCharId") String menuCharId,
            @JsonProperty("routingId") String routingId,
            @JsonProperty("ordinamento") Integer ordinamento,
            @JsonProperty("icone") String icone,
            @JsonProperty("titolo") String titolo,
            @JsonProperty("flgAttiva") String flgAttiva,
            @JsonProperty("homePagina") String homePagina,
            @JsonProperty("tipoMenu") String tipoMenu,
            @JsonProperty("idMenu") String idMenu,
            @JsonProperty("pidMenu") String pidMenu,
            @JsonProperty("queryParams") String queryParams,
            @JsonProperty("nodoId") String nodoId,
            @JsonProperty("version") Long version){
        this.id = id;
        this.menuCharId = menuCharId;
        this.routingId = routingId;
        this.ordinamento = ordinamento;
        this.icone = icone;
        this.titolo = titolo;
        this.flgAttiva = flgAttiva;
        this.homePagina = homePagina;
        this.tipoMenu = tipoMenu;
        this.idMenu = idMenu;
        this.pidMenu = pidMenu;
        this.queryParams = queryParams;
        this.nodoId = nodoId;
        this.version = version;
    }
    public static MenuFilter createFilterFromMap(Object obj) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        MenuFilter filter = new MenuFilter();
        if(map != null){
            filter.setId((String) map.get("id"));
            filter.setMenuCharId((String) map.get("menuCharId"));
            filter.setRoutingId((String) map.get("routingId"));
            filter.setOrdinamento((Integer) map.get("ordinamento"));
            filter.setIcone((String) map.get("icone"));
            filter.setTitolo((String) map.get("titolo"));
            filter.setFlgAttiva((String) map.get("flgAttiva"));
            filter.setHomePagina((String) map.get("homePagina"));
            filter.setTipoMenu((String) map.get("tipoMenu"));
            filter.setIdMenu((String) map.get("idMenu"));
            filter.setPidMenu((String) map.get("pidMenu"));
            filter.setQueryParams((String) map.get("queryParams"));
            filter.setNodoId((String) map.get("nodoId"));

            Object version = map.get("version");
            if(version != null){
                if(version instanceof Integer){
                    filter.setVersion(Long.valueOf((Integer) version));
                } else if (version instanceof Long){
                    filter.setVersion((Long) version);
                }
            }
        }
        return filter;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public String getPidMenu() {
        return pidMenu;
    }

    public void setPidMenu(String pidMenu) {
        this.pidMenu = pidMenu;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }
}
