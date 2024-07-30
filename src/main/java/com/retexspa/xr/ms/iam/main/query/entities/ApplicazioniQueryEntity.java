package com.retexspa.xr.ms.iam.main.query.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.retexspa.xr.ms.iam.main.core.dto.applicazioni.ApplicazioniBaseDTO;
@Entity
@Table(name = "applicazioni",
 uniqueConstraints = {
    @UniqueConstraint(name = "applicazioni_uk", columnNames = { "societa_id", "codice" })
})
public class ApplicazioniQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codice")
    private String codice;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name="version")
    private Long version;

    //foreingkey
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "societa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_applicazione_societa"))
    private SocietaQueryEntity societa;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "iconic_applicazioni_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_applicazione_iconic_applicazione"))
    private IconicApplicazioniQueryEntity iconicApplicazioni;

    //master details
    //  @OneToMany(fetch = FetchType.LAZY, mappedBy = "applicazione")
    //  @JsonIgnore
    //  private Set<TipiContestoApplicazioneQueryEntity>  tipiContestoApplicazione;

    //  @OneToMany(fetch = FetchType.LAZY, mappedBy = "applicazioni")
    //  @JsonIgnore
    //  private Set<RuoliApplicazioneQueryEntity>  ruoliApplicazione;

    //  @OneToMany(fetch = FetchType.LAZY, mappedBy = "applicazione")
    //  @JsonIgnore
    //  private Set<AnagAttributiRuoliQueryEntity>  anagraficaAttributiRuoli;

    //  @OneToMany(fetch = FetchType.LAZY, mappedBy = "applicazione")
    //  @JsonIgnore
    //  private Set<AnagAttributiRuoliQueryEntity>  anagraficaAttributiRuoliShared;


    @Column(name="immagine")
    @Lob
    private byte[] immagine;
    @Column(name="flgRuoloUnico")
    private String flgRuoloUnico;

    public ApplicazioniQueryEntity() {
    }

    public ApplicazioniQueryEntity(@NotNull String id, ApplicazioniBaseDTO dto, Long version) {
        this.id = id;
        this.descrizione = dto.getDescrizione();
        this.nome = dto.getNome();
        this.codice = dto.getCodice();
        this.version = version;
        this.immagine = dto.getImmagine();
        this.flgRuoloUnico = dto.getFlgRuoloUnico();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public SocietaQueryEntity getSocieta() {
        return societa;
    }

    public void setSocieta(SocietaQueryEntity societa) {
        this.societa = societa;
    }

    public byte[] getImmagine() {
        return immagine;
    }

    public void setImmagine(byte[] immagine) {
        this.immagine = immagine;
    }

    public String getFlgRuoloUnico() {
        return flgRuoloUnico;
    }

    public void setFlgRuoloUnico(String flgRuoloUnico) {
        this.flgRuoloUnico = flgRuoloUnico;
    }

    public IconicApplicazioniQueryEntity getIconicApplicazioni() {
        return iconicApplicazioni;
    }

    public void setIconicApplicazioni(IconicApplicazioniQueryEntity iconicApplicazioni) {
        this.iconicApplicazioni = iconicApplicazioni;
    }
}
