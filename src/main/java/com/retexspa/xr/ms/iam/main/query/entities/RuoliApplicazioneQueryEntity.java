package com.retexspa.xr.ms.iam.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.iam.main.core.dto.ruoliApplicazione.RuoliApplicazioneBaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import org.springframework.lang.NonNull;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ruoli_applicazione", indexes = {
        @Index(name = "ruoli_applicazione_applicazione", columnList = "applicazioni_id") }, uniqueConstraints = {
                @UniqueConstraint(name = "ruoli_applicazione_uk", columnNames = { "codice", "applicazioni_id" })
        })
public class RuoliApplicazioneQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "codice")
    private String codice;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descrizione")
    private String descrizione;

    @EnumValidator(enumClazz = Enums.CheckSN.class)
    @Column(name = "flg_attivo")
    private String flgAttivo;

    @Column(name = "livello_iam")
    private Integer livelloIam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicazioni_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ruoliApplicazione_applicazioni"))
    private ApplicazioniQueryEntity applicazioni;

    @Column(name = "version")
    private Long version;

    // details
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ruolo")
    @JsonIgnore
    private Set<RuoliRoutingQueryEntity> ruoliRouting;

    public RuoliApplicazioneQueryEntity() {
    }

    public RuoliApplicazioneQueryEntity(
            @NonNull String id,
            RuoliApplicazioneBaseDTO dto,
            Long version) {
        this.id = id;
        this.codice = dto.getCodice();
        this.nome = dto.getNome();
        this.descrizione = dto.getDescrizione();
        this.flgAttivo = dto.getFlgAttivo();
        this.livelloIam = dto.getLivelloIam();
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFlgAttivo() {
        return flgAttivo;
    }

    public void setFlgAttivo(String flgAttivo) {
        this.flgAttivo = flgAttivo;
    }

    public Integer getLivelloIam() {
        return livelloIam;
    }

    public void setLivelloIam(Integer livelloIam) {
        this.livelloIam = livelloIam;
    }

    public ApplicazioniQueryEntity getApplicazioni() {
        return applicazioni;
    }

    public void setApplicazioni(ApplicazioniQueryEntity applicazioni) {
        this.applicazioni = applicazioni;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Set<RuoliRoutingQueryEntity> getRuoliRouting() {
        return ruoliRouting;
    }

    public void setRuoliRouting(Set<RuoliRoutingQueryEntity> ruoliRouting) {
        this.ruoliRouting = ruoliRouting;
    }

}
