package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.contestiApplicazioni.ContestiApplicazioniBaseDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contesti_applicazioni", uniqueConstraints = {
    @UniqueConstraint(name = "contesti_applicazioni_uk", columnNames = { "codice", "tipo_contesto_applicazione_id" })
})
public class ContestiApplicazioniQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "codice")
    private String codice;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name="flg_acquisizione_auto")
    private String flgAcquisizioneAuto;


     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "tipo_contesto_applicazione_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_contestiApplicazioni_tipi_contesto_applicazione"))
     private TipiContestoApplicazioneQueryEntity tipoContestoApplicazione;

    @Column(name="version")
    private Long version;

    public ContestiApplicazioniQueryEntity() {
    }

    public ContestiApplicazioniQueryEntity(
            @NotNull String id,
            ContestiApplicazioniBaseDTO dto,
            Long version) {
        this.id = id;
        this.codice = dto.getCodice();
        this.nome = dto.getNome();
        this.descrizione = dto.getDescrizione();
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

    public String getFlgAcquisizioneAuto() {
        return flgAcquisizioneAuto;
    }

    public void setFlgAcquisizioneAuto(String flgAcquisizioneAuto) {
        this.flgAcquisizioneAuto = flgAcquisizioneAuto;
    }

    public TipiContestoApplicazioneQueryEntity getTipoContestoApplicazione() {
        return tipoContestoApplicazione;
    }

    public void setTipoContestoApplicazione(TipiContestoApplicazioneQueryEntity tipoContestoApplicazione) {
        this.tipoContestoApplicazione = tipoContestoApplicazione;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
