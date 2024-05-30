package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.notifiche.NotificheBaseDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "notifiche")
public class NotificheQueryEntity {

    @Id @NonNull private String id;
    @Column(name = "codice")
    private String codice;
    @Column(name = "titolo")
    private String titolo;
    @Column(name = "dettaglio")
    private String dettaglio;
    @Column(name = "icone")
    private String icone;
    @Column(name = "flgAttiva")
    private String flgAttiva;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routing_id", referencedColumnName = "id")
    private RoutingQueryEntity routing;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iconic_applicazioni_id", referencedColumnName = "id")
    private IconicApplicazioniQueryEntity iconicApplicazioni;
    @Column(name="version")
    private Long version;
    public NotificheQueryEntity() {
    }
    public NotificheQueryEntity(@NotNull String id, NotificheBaseDTO dto, Long version) {
        this.id = id;
        this.codice = dto.getCodice();
        this.titolo = dto.getTitolo();
        this.icone = dto.getIcone();
        this.dettaglio = dto.getDettaglio();
        this.flgAttiva = dto.getFlgAttiva();
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

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDettaglio() {
        return dettaglio;
    }

    public void setDettaglio(String dettaglio) {
        this.dettaglio = dettaglio;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getFlgAttiva() {
        return flgAttiva;
    }

    public void setFlgAttiva(String flgAttiva) {
        this.flgAttiva = flgAttiva;
    }

    public RoutingQueryEntity getRouting() {
        return routing;
    }

    public void setRouting(RoutingQueryEntity routing) {
        this.routing = routing;
    }

    public IconicApplicazioniQueryEntity getIconicApplicazioni() {
        return iconicApplicazioni;
    }

    public void setIconicApplicazioni(IconicApplicazioniQueryEntity iconicApplicazioni) {
        this.iconicApplicazioni = iconicApplicazioni;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
