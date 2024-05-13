package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.ruoliRoutingSections.RuoliRoutingSectionsBaseDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ruoliRoutingSections")
public class RuoliRoutingSectionsQueryEntity {
    @Id
    @NonNull
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruoli_routing_id", referencedColumnName = "id")
    private RuoliRoutingQueryEntity ruoliRouting;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rourintg_section_id", referencedColumnName = "id")
    private RoutingSectionsQueryEntity routingSection;
    @Column(name = "flgAttiva")
    private String flgAttiva;

    @Column(name = "flgReadonly")
    private String flgReadonly;

    @Column(name = "flgInsert")
    private String flgInsert;

    @Column(name = "flgUpdate")
    private String flgUpdate;

    @Column(name = "flgDelete")
    private String flgDelete;
    @Column(name="version")
    private Long version;
    public RuoliRoutingSectionsQueryEntity(){}
    public RuoliRoutingSectionsQueryEntity(@NotNull String id, RuoliRoutingSectionsBaseDTO dto, Long version) {
        this.id = id;
        this.flgAttiva = dto.getFlgAttiva();
        this.flgReadonly = dto.getFlgReadonly();
        this.flgInsert = dto.getFlgInsert();
        this.flgUpdate = dto.getFlgUpdate();
        this.flgDelete = dto.getFlgDelete();
        this.version = version;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }


    public RuoliRoutingQueryEntity getRuoliRouting() {
        return ruoliRouting;
    }

    public void setRuoliRouting(RuoliRoutingQueryEntity ruoliRouting) {
        this.ruoliRouting = ruoliRouting;
    }

    public RoutingSectionsQueryEntity getRoutingSection() {
        return routingSection;
    }

    public void setRoutingSection(RoutingSectionsQueryEntity routingSection) {
        this.routingSection = routingSection;
    }

    public String getFlgAttiva() {
        return flgAttiva;
    }

    public void setFlgAttiva(String flgAttiva) {
        this.flgAttiva = flgAttiva;
    }

    public String getFlgReadonly() {
        return flgReadonly;
    }

    public void setFlgReadonly(String flgReadonly) {
        this.flgReadonly = flgReadonly;
    }

    public String getFlgInsert() {
        return flgInsert;
    }

    public void setFlgInsert(String flgInsert) {
        this.flgInsert = flgInsert;
    }

    public String getFlgUpdate() {
        return flgUpdate;
    }

    public void setFlgUpdate(String flgUpdate) {
        this.flgUpdate = flgUpdate;
    }

    public String getFlgDelete() {
        return flgDelete;
    }

    public void setFlgDelete(String flgDelete) {
        this.flgDelete = flgDelete;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
