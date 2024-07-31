package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.anagAttributiRuoli.AnagAttributiRuoliBaseDTO;
import com.retexspa.xr.ms.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "anag_attributi_ruoli", uniqueConstraints = {
    @UniqueConstraint(name = "anag_attributi_ruoli_uk", columnNames = { "nome_attributo", "applicazioni_id" })
})
public class AnagAttributiRuoliQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "nome_attributo")
    private String nomeAttributo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicazioni_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_anagAttributiRuoli_applicazione"))
    private ApplicazioniQueryEntity applicazione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "share_applicazioni_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_anagAttributiRuoli_share_applicazione"))
    private ApplicazioniQueryEntity shareApplicazione;

    @Column(name = "tipo")
    private String tipo;
    @Column(name = "formato")
    private String formato;
    @Column(name = "posizione")
    private Integer posizione;
    @EnumValidator(enumClazz = Enums.CheckSN.class)
    @Column(name = "flg_cifrato")
    private String flgCifrato;
    @EnumValidator(enumClazz = Enums.CheckSN.class)
    @Column(name = "flg_unico")
    private String flgUnico;
    @EnumValidator(enumClazz = Enums.CheckSN.class)
    @Column(name = "flg_obbligatorio")
    private String flgObbligatorio;
    @Column(name = "default_value")
    private String defaultValue;
    @Column(name = "check_function")
    private String checkFunction;
    @Column(name="version")
    private Long version;

    public AnagAttributiRuoliQueryEntity() {
    }

    public AnagAttributiRuoliQueryEntity(@NotNull String id, AnagAttributiRuoliBaseDTO dto, Long version) {
        this.id = id;
        this.nomeAttributo= dto.getNomeAttributo();
        this.tipo = dto.getTipo();
        this.formato = dto.getFormato();
        this.posizione = dto.getPosizione();
        this.flgCifrato = dto.getFlgCifrato();
        this.flgUnico =dto.getFlgUnico();
        this.flgObbligatorio= dto.getFlgObbligatorio();
        this.version = version;
        this.defaultValue = dto.getDefaultValue();
        this.checkFunction =dto.getCheckFunction();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getNomeAttributo() {
        return nomeAttributo;
    }

    public void setNomeAttributo(String nomeAttributo) {
        this.nomeAttributo = nomeAttributo;
    }

    public ApplicazioniQueryEntity getApplicazione() {
        return applicazione;
    }

    public void setApplicazione(ApplicazioniQueryEntity applicazione) {
        this.applicazione = applicazione;
    }

    public ApplicazioniQueryEntity getShareApplicazione() {
        return shareApplicazione;
    }

    public void setShareApplicazione(ApplicazioniQueryEntity shareApplicazione) {
        this.shareApplicazione = shareApplicazione;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Integer getPosizione() {
        return posizione;
    }

    public void setPosizione(Integer posizione) {
        this.posizione = posizione;
    }

    public String getFlgCifrato() {
        return flgCifrato;
    }

    public void setFlgCifrato(String flgCifrato) {
        this.flgCifrato = flgCifrato;
    }

    public String getFlgUnico() {
        return flgUnico;
    }

    public void setFlgUnico(String flgUnico) {
        this.flgUnico = flgUnico;
    }

    public String getFlgObbligatorio() {
        return flgObbligatorio;
    }

    public void setFlgObbligatorio(String flgObbligatorio) {
        this.flgObbligatorio = flgObbligatorio;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getCheckFunction() {
        return checkFunction;
    }

    public void setCheckFunction(String checkFunction) {
        this.checkFunction = checkFunction;
    }
}
