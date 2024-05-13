package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.routingSections.RoutingSectionsBaseDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "routingSections")
public class RoutingSectionsQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "codice")
    private String codice;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name="version")
    private Long version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routing_id", referencedColumnName = "id")
    private RoutingQueryEntity routing;

    public RoutingSectionsQueryEntity() {
    }

    public RoutingSectionsQueryEntity(@NotNull String id, RoutingSectionsBaseDTO dto, Long version) {
        this.id = id;
        this.descrizione = dto.getDescrizione();
        this.codice = dto.getCodice();
        this.version = version;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public RoutingQueryEntity getRouting() {
        return routing;
    }

    public void setRouting(RoutingQueryEntity routing) {
        this.routing = routing;
    }
}
