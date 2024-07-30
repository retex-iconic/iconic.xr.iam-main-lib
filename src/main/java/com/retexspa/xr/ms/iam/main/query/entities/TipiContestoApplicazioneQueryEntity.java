package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.tipiContestoApplicazione.TipiContestoApplicazioneBaseDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipiContestoApplicazione", uniqueConstraints = {
        @UniqueConstraint(name = "tipi_contesto_applicazione_uk", columnNames = { "applicazione_id", "tipi_contesto_id",
                "tassonomia_id" }) })
public class TipiContestoApplicazioneQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "version")
    private Long version;

    @Column(name = "tassonomia_id")
    private String tassonomiaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicazione_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tipiContestoApplicazione_applicazione"))
    private ApplicazioniQueryEntity applicazione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipi_contesto_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tipiContestoApplicazione_tipi_contesto"))
    private TipiContestoQueryEntity tipiContesto;

    public TipiContestoApplicazioneQueryEntity() {
    }

    public TipiContestoApplicazioneQueryEntity(@NotNull String id, TipiContestoApplicazioneBaseDTO dto, Long version) {
        this.id = id;
        this.tassonomiaId = dto.getTassonomiaId();
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public ApplicazioniQueryEntity getApplicazione() {
        return applicazione;
    }

    public void setApplicazione(ApplicazioniQueryEntity applicazione) {
        this.applicazione = applicazione;
    }

    public TipiContestoQueryEntity getTipiContesto() {
        return tipiContesto;
    }

    public void setTipiContesto(TipiContestoQueryEntity tipiContesto) {
        this.tipiContesto = tipiContesto;
    }

    public String getTassonomiaId() {
        return tassonomiaId;
    }

    public void setTassonomiaId(String tassonomiaId) {
        this.tassonomiaId = tassonomiaId;
    }

}
