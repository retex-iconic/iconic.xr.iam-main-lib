package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.attributiRuoli.AttributiRuoliBaseDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "attributi_ruoli")
public class AttributiRuoliQueryEntity {

    @Id
    @NonNull
    private String id;

    private String valore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruolo_id", referencedColumnName = "id")
    private RuoliApplicazioneQueryEntity ruolo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attributoRuolo_id", referencedColumnName = "id")
    private AnagAttributiRuoliQueryEntity attributoRuolo;

    private Long version;

    public AttributiRuoliQueryEntity(@NonNull String id, AttributiRuoliBaseDTO dto, Long version) {
        this.id = id;
        this.valore = dto.getValore();
        this.version = version;
    }

    public void setAttributoRuolo(AnagAttributiRuoliQueryEntity attributoRuolo) {
        this.attributoRuolo = attributoRuolo;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public AttributiRuoliQueryEntity() {

    }

    public AnagAttributiRuoliQueryEntity getAttributoRuolo() {
        return attributoRuolo;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public RuoliApplicazioneQueryEntity getRuolo() {
        return ruolo;
    }

    public void setRuolo(RuoliApplicazioneQueryEntity ruolo) {
        this.ruolo = ruolo;
    }


}
