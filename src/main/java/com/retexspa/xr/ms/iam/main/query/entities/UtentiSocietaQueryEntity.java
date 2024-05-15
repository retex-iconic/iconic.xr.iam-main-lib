package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.iam.main.core.dto.utentiSocieta.UtentiSocietaBaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "utenti_societa", indexes = {
    @Index(name = "index_utenti_id", columnList = "id"),
    @Index(name = "index_utenti_societa_matricola", columnList = "matricola"),
    @Index(name = "index_utenti_societa_nome", columnList = "nome"),
    @Index(name = "index_utenti_societa_cognome", columnList = "cognome"),
    @Index(name = "index_utenti_societa_codice_fiscale", columnList = "codice_fiscale"),
    @Index(name = "index_utenti_societa_badge_id", columnList = "badge_id"),
    @Index(name = "index_utenti_societa_societa", columnList = "societa_id")
})
public class UtentiSocietaQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "id_account")
    private String idAccount;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

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

    @Column(name = "codice_fiscale")
    private String codiceFiscale;

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
        this.idAccount = dto.getIdAccount();
        this.nome = dto.getNome();
        this.cognome = dto.getCognome();
        this.dataInizioValidita = dto.getDataInizioValidita();
        this.dataFineValidita = dto.getDataFineValidita();
        this.matricola = dto.getMatricola();
        this.statoBadge = dto.getStatoBadge();
        this.codiceFiscale = dto.getCodiceFiscale();
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

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
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

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
