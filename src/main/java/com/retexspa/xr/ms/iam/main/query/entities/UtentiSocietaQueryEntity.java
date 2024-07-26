package com.retexspa.xr.ms.iam.main.query.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.lang.NonNull;

import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.iam.main.core.dto.utentiSocieta.UtentiSocietaBaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

@Entity
@Table(name = "utenti_societa", uniqueConstraints = { 
    @UniqueConstraint(columnNames = { "utente_id", "societa_id" }, name = "uk_utente_societa"),
    @UniqueConstraint(columnNames = { "matricola", "societa_id" }, name = "uk_utenti_societa_matricola"),
    @UniqueConstraint(columnNames = { "upn", "societa_id" }, name = "uk_utenti_societa_upn") }, 
indexes = {
    @Index(name = "index_utenti_societa_id", columnList = "id"),
    @Index(name = "index_utenti_societa_matricola", columnList = "matricola"),
    @Index(name = "index_utenti_societa_badge_id", columnList = "badge_id"),
    @Index(name = "index_utenti_societa_utente_id", columnList = "utente_id"),
    @Index(name = "index_utenti_societa_societa", columnList = "societa_id")
})
public class UtentiSocietaQueryEntity {

    @Id
    @NonNull
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utente_id", referencedColumnName = "id")
    private UtentiQueryEntity utente;

    @Column(name = "data_inizio_validita")
    private LocalDateTime dataInizioValidita;

    @Column(name = "data_fine_validita")
    private LocalDateTime dataFineValidita;

    @Column(name = "matricola")
    private String matricola;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_id", referencedColumnName = "id")
    private BadgeSocietaQueryEntity badge;

    @EnumValidator(enumClazz = Enums.StatoBadge.class)
    @Column(name = "stato_badge")
    private String statoBadge;

    @Column(name = "indirizzo_email")
    private String indirrizoEmail;

    @Column(name = "upn")
    private String upn;

    @Column(name = "pwd")
    private String pwd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "societa_id", referencedColumnName = "id")
    private SocietaQueryEntity societa;

    @Column(name="version")
    private Long version;

    public UtentiSocietaQueryEntity() {
    }

    public UtentiSocietaQueryEntity(@NonNull String id, UtentiSocietaBaseDTO dto, Long version) {
        this.id = id;
        this.dataInizioValidita = dto.getDataInizioValidita();
        this.dataFineValidita = dto.getDataFineValidita();
        this.matricola = dto.getMatricola();
        this.statoBadge = dto.getStatoBadge();
        this.indirrizoEmail = dto.getIndirrizoEmail();
        this.upn = dto.getUpn();
        this.pwd = dto.getPwd();
        this.version = version;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
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

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public BadgeSocietaQueryEntity getBadge() {
        return badge;
    }

    public void setBadge(BadgeSocietaQueryEntity badge) {
        this.badge = badge;
    }

    public String getStatoBadge() {
        return statoBadge;
    }

    public void setStatoBadge(String statoBadge) {
        this.statoBadge = statoBadge;
    }

    public String getIndirrizoEmail() {
        return indirrizoEmail;
    }

    public void setIndirrizoEmail(String indirrizoEmail) {
        this.indirrizoEmail = indirrizoEmail;
    }

    public String getUpn() {
        return upn;
    }

    public void setUpn(String upn) {
        this.upn = upn;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public SocietaQueryEntity getSocieta() {
        return societa;
    }

    public void setSocieta(SocietaQueryEntity societa) {
        this.societa = societa;
    }

    public UtentiQueryEntity getUtente() {
        return utente;
    }

    public void setUtente(UtentiQueryEntity utenteId) {
        this.utente = utenteId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
