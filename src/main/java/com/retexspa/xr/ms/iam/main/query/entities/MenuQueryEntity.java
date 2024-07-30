package com.retexspa.xr.ms.iam.main.query.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.retexspa.xr.ms.iam.main.core.dto.menu.MenuBaseDTO;

@Entity
@Table(name = "menu")
public class MenuQueryEntity {
    @Id @NonNull
    private String id;
    @Column(name = "menuCharId")
    private String menuCharId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routing_id", referencedColumnName = "id")
    private RoutingQueryEntity routing;
    @Column(name = "ordinamento")
    private Integer ordinamento;
    @Column(name = "icone")
    private String icone;
    @Column(name = "queryParams")
    private String queryParams;
    @Column(name = "titolo")
    private String titolo;
    @Column(name = "flgAttiva")
    private String flgAttiva;
    @Column(name = "homePagina")
    private String homePagina;
    @Column(name = "tipoMenu")
    private String tipoMenu;
    @Column(name = "idMenu")
    private Integer idMenu;
    @Column(name = "pidMenu")
    private Integer pidMenu;
    @ManyToOne(fetch = FetchType.LAZY)
    private MenuQueryEntity nodo;
    @Column(name="version")
    private Long version;

    @Column(name="menuName")
    private String menuName;

    @Column(name="menuDefault")
    private String menuDefault;
    
    public MenuQueryEntity() {
    }
    public MenuQueryEntity(@NotNull String id, MenuBaseDTO dto, Long version) {
        this.id = id;
        this.menuCharId = dto.getMenuCharId();
        this.ordinamento = dto.getOrdinamento();
        this.icone = dto.getIcone();
        this.queryParams = dto.getQueryParams();
        this.titolo = dto.getTitolo();
        this.flgAttiva = dto.getFlgAttiva();
        this.homePagina = dto.getHomePagina();
        this.tipoMenu = dto.getTipoMenu();
        this.idMenu = dto.getIdMenu();
        this.menuDefault = dto.getMenuName();
        this.menuName = dto.getMenuDefault();
        this.version = version;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getMenuCharId() {
        return menuCharId;
    }

    public void setMenuCharId(String menuCharId) {
        this.menuCharId = menuCharId;
    }

    public RoutingQueryEntity getRouting() {
        return routing;
    }

    public void setRouting(RoutingQueryEntity routing) {
        this.routing = routing;
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

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public MenuQueryEntity getNodo() {
        return nodo;
    }

    public void setNodo(MenuQueryEntity nodo) {
        this.nodo = nodo;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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
