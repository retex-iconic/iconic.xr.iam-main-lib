package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.attributiUtenti.AttributiUtentiBaseDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "attributi_utenti", uniqueConstraints = {
        @UniqueConstraint(name = "attributi_utenti_uk", columnNames = {
                "utente_applicazione_id",
                "attributi_utenti_id",
                "contesto_applicazione_id"
        })
})
public class AttributiUtentiQueryEntity {

    @Id
    @NonNull
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utente_applicazione_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_attributiUtenti_utenti_applicazioni"))
    private UtentiApplicazioniQueryEntity utenteApplicazione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attributi_utenti_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_attributiUtenti_anag_attributi_utenti"))
    private AnagAttributiUtentiQueryEntity attributoUtenti;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contesto_applicazione_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_attributiUtenti_contesto_applicazione"))
    private ContestiApplicazioniQueryEntity contestoApplicazione;

    @Column(name = "version")
    private Long version;

    @Column(name = "valore")
    private String valore;

    public AttributiUtentiQueryEntity() {
    }

    public AttributiUtentiQueryEntity(
            @NonNull String id,
            AttributiUtentiBaseDTO dto,
            Long version) {
        this.id = id;
        this.valore = dto.getValore();
        this.version = version;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public UtentiApplicazioniQueryEntity getUtenteApplicazione() {
        return utenteApplicazione;
    }

    public void setUtenteApplicazione(UtentiApplicazioniQueryEntity utenteApplicazione) {
        this.utenteApplicazione = utenteApplicazione;
    }

    public AnagAttributiUtentiQueryEntity getAttributoUtenti() {
        return attributoUtenti;
    }

    public void setAttributoUtenti(AnagAttributiUtentiQueryEntity attributoUtenti) {
        this.attributoUtenti = attributoUtenti;
    }

    public ContestiApplicazioniQueryEntity getContestoApplicazione() {
        return contestoApplicazione;
    }

    public void setContestoApplicazione(ContestiApplicazioniQueryEntity contestoApplicazione) {
        this.contestoApplicazione = contestoApplicazione;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }
}
