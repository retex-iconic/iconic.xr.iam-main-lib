package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.ruoliRouting.RuoliRoutingBaseDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ruoli_routing", uniqueConstraints = {
    @UniqueConstraint(name = "ruoli_routing_uk", columnNames = { "routing_id", "ruolo_id" })
})
public class RuoliRoutingQueryEntity {
    @Id @NonNull private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routing_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ruoliRouting_routing"))
    private RoutingQueryEntity routing;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruolo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ruoliRouting_ruolo"))
    private RuoliApplicazioneQueryEntity ruolo;
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
    public RuoliRoutingQueryEntity(){}
    public RuoliRoutingQueryEntity(@NotNull String id, RuoliRoutingBaseDTO dto, Long version) {
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

    public RoutingQueryEntity getRouting() {
        return routing;
    }

    public void setRouting(RoutingQueryEntity routing) {
        this.routing = routing;
    }

    public RuoliApplicazioneQueryEntity getRuolo() {
        return ruolo;
    }

    public void setRuolo(RuoliApplicazioneQueryEntity ruolo) {
        this.ruolo = ruolo;
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
