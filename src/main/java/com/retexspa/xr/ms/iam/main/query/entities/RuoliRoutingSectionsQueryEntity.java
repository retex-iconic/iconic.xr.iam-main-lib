package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.ruoliRoutingSections.RuoliRoutingSectionsBaseDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ruoli_routing_sections", uniqueConstraints = {
    @UniqueConstraint(name = "ruoli_routing_sections_uk", columnNames = { "ruoli_routing_id", "routing_section_id" })
})
public class RuoliRoutingSectionsQueryEntity {
    @Id
    @NonNull
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruoli_routing_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ruoliRoutingSections_ruoli_routing"))
    private RuoliRoutingQueryEntity ruoliRouting;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routing_section_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ruoliRoutingSections_routing_section"))
    private RoutingSectionsQueryEntity routingSection;
    @Column(name = "flg_attiva")
    private String flgAttiva;

    @Column(name = "flg_readonly")
    private String flgReadonly;

    @Column(name = "flg_insert")
    private String flgInsert;

    @Column(name = "flg_update")
    private String flgUpdate;

    @Column(name = "flg_delete")
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
