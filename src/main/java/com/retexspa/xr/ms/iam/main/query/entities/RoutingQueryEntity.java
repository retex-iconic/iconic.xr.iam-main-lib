package com.retexspa.xr.ms.iam.main.query.entities;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.retexspa.xr.ms.iam.main.core.dto.routing.RoutingBaseDTO;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "routing")
public class RoutingQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "routingCharId")
    private String routingCharId;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "urlLink")
    private String urlLink;
    @Column(name = "icone")
    private String icone;

    @Column(name="version")
    private Long version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iconic_applicazione_id", referencedColumnName = "id")
    private IconicApplicazioniQueryEntity iconicApplicazioni;

    @ManyToOne(fetch = FetchType.LAZY)
    private RoutingQueryEntity nodo;

    @Column(name="subtitolo")
    private String subtitolo;
    @Column(name="flgGdpr")
    private String flgGdpr;

    // master detail
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "routing")
    @JsonIgnore
    private Set<MenuQueryEntity> menu;
 
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "routing")
    @JsonIgnore
    private Set<RuoliRoutingQueryEntity> ruoliRouting;
    
    
    public RoutingQueryEntity() {
    }

    public RoutingQueryEntity(@NotNull String id, RoutingBaseDTO dto, Long version) {
        this.id = id;
        this.routingCharId = dto.getRoutingCharId();
        this.titolo = dto.getTitolo();
        this.urlLink = dto.getUrlLink();
        this.icone = dto.getIcone();
        this.version = version;
        this.subtitolo = dto.getSubtitolo();
        this.icone = dto.getIcone();
        this.flgGdpr = dto.getFlgGdpr();
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getRoutingCharId() {
        return routingCharId;
    }

    public void setRoutingCharId(String routingCharId) {
        this.routingCharId = routingCharId;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public IconicApplicazioniQueryEntity getIconicApplicazioni() {
        return iconicApplicazioni;
    }

    public void setIconicApplicazioni(IconicApplicazioniQueryEntity iconicApplicazione) {
        this.iconicApplicazioni = iconicApplicazione;
    }

    public RoutingQueryEntity getNodo() {
        return nodo;
    }

    public void setNodo(RoutingQueryEntity nodo) {
        this.nodo = nodo;
    }

    public String getSubtitolo() {
        return subtitolo;
    }

    public void setSubtitolo(String subtitolo) {
        this.subtitolo = subtitolo;
    }

    public String getFlgGdpr() {
        return flgGdpr;
    }

    public void setFlgGdpr(String flgGdpr) {
        this.flgGdpr = flgGdpr;
    }

    public Set<MenuQueryEntity> getMenu() {
        return menu;
    }

    public void setMenu(Set<MenuQueryEntity> menu) {
        this.menu = menu;
    }

    public Set<RuoliRoutingQueryEntity> getRuoliRouting() {
        return ruoliRouting;
    }

    public void setRuoliRouting(Set<RuoliRoutingQueryEntity> ruoliRouting) {
        this.ruoliRouting = ruoliRouting;
    }

}
