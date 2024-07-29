package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.iam.main.core.dto.utentiApplicazioni.UtentiApplicazioniBaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "utenti_applicazioni", uniqueConstraints = {
        @UniqueConstraint(name = "utenti_applicazioni_uk", columnNames = { "utenti_id", "contesto_id", "ruolo_id" })
}, indexes = {
        @Index(name = "utenti_applicazioni_ruolo", columnList = "ruolo_id"),
        @Index(name = "utenti_applicazioni_contesto", columnList = "contesto_id"),
        @Index(name = "utenti_applicazioni_utente_societa", columnList = "utenti_id"),
        @Index(name = "utenti_applicazioni_data_inizio_validita", columnList = "data_inizio_validita"),
        @Index(name = "utenti_applicazioni_data_fine_validita", columnList = "data_fine_validita")
})
public class UtentiApplicazioniQueryEntity {

    @Id
    @NonNull
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utenti_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_utentiApplicazioni_utente"))
    private UtentiSocietaQueryEntity utente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contesto_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_utentiApplicazioni_contesto"))
    private ContestiApplicazioniQueryEntity contesto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruolo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_utentiApplicazioni_ruolo"))
    private RuoliApplicazioneQueryEntity ruolo;

    @Column(name = "data_inizio_validita")
    private LocalDateTime dataInizioValidita;

    @Column(name = "data_fine_validita")
    private LocalDateTime dataFineValidita;

    @EnumValidator(enumClazz = Enums.CheckSN.class)
    private String flgAcquisizioneAuto;

    @Column(name = "version")
    private Long version;

    public UtentiApplicazioniQueryEntity() {
    }

    public UtentiApplicazioniQueryEntity(@NotNull String id, UtentiApplicazioniBaseDTO dto, Long version) {
        this.id = id;
        this.dataInizioValidita = dto.getDataInizioValidita();
        this.dataFineValidita = dto.getDataFineValidita();
        this.flgAcquisizioneAuto = dto.getFlgAcquisizioneAuto();
        this.version = version;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public UtentiSocietaQueryEntity getUtente() {
        return utente;
    }

    public void setUtente(UtentiSocietaQueryEntity utente) {
        this.utente = utente;
    }

    public ContestiApplicazioniQueryEntity getContesto() {
        return contesto;
    }

    public void setContesto(ContestiApplicazioniQueryEntity contesto) {
        this.contesto = contesto;
    }

    public RuoliApplicazioneQueryEntity getRuolo() {
        return ruolo;
    }

    public void setRuolo(RuoliApplicazioneQueryEntity ruolo) {
        this.ruolo = ruolo;
    }

    public LocalDateTime getDataInizioValidita() {
        return dataInizioValidita;
    }

    public void setDataInizioValidita(LocalDateTime dataInizioValidita) {
        this.dataInizioValidita = dataInizioValidita;
    }

    public LocalDateTime getDataFineValidita() {
        return dataFineValidita;
    }

    public void setDataFineValidita(LocalDateTime dataFineValidita) {
        this.dataFineValidita = dataFineValidita;
    }

    public String getFlgAcquisizioneAuto() {
        return flgAcquisizioneAuto;
    }

    public void setFlgAcquisizioneAuto(String flgAcquisizioneAuto) {
        this.flgAcquisizioneAuto = flgAcquisizioneAuto;
    }
}
