package com.retexspa.xr.ms.iam.main.query.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ruoli_notifiche", uniqueConstraints = {
    @UniqueConstraint(name = "ruoli_notifiche_uk", columnNames = { "notifica_id", "ruolo_id" })
})
public class RuoliNotificheQueryEntity {
    @Id
    @NonNull
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notifica_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ruoliNotifiche_notifiche"))
    private NotificheQueryEntity notifica;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruolo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ruoliNotifiche_ruolo"))
    private RuoliApplicazioneQueryEntity ruolo;
    @Column(name="version")
    private Long version;
    public RuoliNotificheQueryEntity() {
    }
    public RuoliNotificheQueryEntity(@NotNull String id, Long version) {
        this.id = id;
        this.version = version;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public NotificheQueryEntity getNotifica() {
        return notifica;
    }

    public void setNotifica(NotificheQueryEntity notifica) {
        this.notifica = notifica;
    }

    public RuoliApplicazioneQueryEntity getRuolo() {
        return ruolo;
    }

    public void setRuolo(RuoliApplicazioneQueryEntity ruolo) {
        this.ruolo = ruolo;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
