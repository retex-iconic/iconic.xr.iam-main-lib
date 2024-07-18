package com.retexspa.xr.ms.iam.main.query.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.retexspa.xr.ms.iam.main.core.dto.sostituzioniBadge.SostituzioniBadgeBaseDTO;
@Entity
@Table(name = "sostituzioni_badge")
public class SostituzioniBadgeQueryEntity {
    
    @Id
    @NonNull
    private String id;

    @Column(name="causale")
    private String causale;
    @Column(name="dataRiconsegna")
    private LocalDateTime dataRiconsegna;

    @Column(name="dataBlocco")
    private LocalDateTime dataBlocco;
    @Column(name="dataSblocco")
    private LocalDateTime dataSblocco;

    @Column(name="dataAssegnazione")
    private LocalDateTime dataAssegnazione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_id", referencedColumnName = "id")
    private BadgeSocietaQueryEntity badge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utenti_id", referencedColumnName = "id")
    private UtentiSocietaQueryEntity utenti;

    @Column(name="version")
    private Long version;

    public SostituzioniBadgeQueryEntity() {
    }

    
    public SostituzioniBadgeQueryEntity(@NotNull String id, SostituzioniBadgeBaseDTO dto, Long version) {
        this.id = id;
        this.dataAssegnazione = dto.getDataAssegnazione();
        this.dataBlocco= dto.getDataBlocco();
        this.dataSblocco = dto.getDataSblocco();
        this.dataRiconsegna = dto.getDataRiconsegna();
        this.causale = dto.getCausale();
        this.version = version;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getCausale() {
        return causale;
    }


    public void setCausale(String causale) {
        this.causale = causale;
    }


    public LocalDateTime getDataRiconsegna() {
        return dataRiconsegna;
    }


    public void setDataRiconsegna(LocalDateTime dataRiconsegna) {
        this.dataRiconsegna = dataRiconsegna;
    }


    public LocalDateTime getDataBlocco() {
        return dataBlocco;
    }


    public void setDataBlocco(LocalDateTime dataBlocco) {
        this.dataBlocco = dataBlocco;
    }


    public LocalDateTime getDataSblocco() {
        return dataSblocco;
    }


    public void setDataSblocco(LocalDateTime dataSblocco) {
        this.dataSblocco = dataSblocco;
    }


    public LocalDateTime getDataAssegnazione() {
        return dataAssegnazione;
    }


    public void setDataAssegnazione(LocalDateTime dataAssegnazione) {
        this.dataAssegnazione = dataAssegnazione;
    }


    public BadgeSocietaQueryEntity getBadge() {
        return badge;
    }


    public void setBadge(BadgeSocietaQueryEntity badge) {
        this.badge = badge;
    }


    public UtentiSocietaQueryEntity getUtenti() {
        return utenti;
    }


    public void setUtenti(UtentiSocietaQueryEntity utenti) {
        this.utenti = utenti;
    }


    public Long getVersion() {
        return version;
    }


    public void setVersion(Long version) {
        this.version = version;
    }

    

}
