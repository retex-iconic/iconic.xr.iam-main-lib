package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.anagAttributiUtenti.AnagAttributiUtentiBaseDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "anag_attributi_utenti", uniqueConstraints = {
    @UniqueConstraint(name = "anag_attributi_utenti_uk", columnNames = { "nome_attributo", "tipo_contesto_applicazione_id" })
})
public class AnagAttributiUtentiQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "nome_attributo")
    private String nomeAttributo;

    @Column(name = "posizione")
    private Integer posizione;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "formato")
    private String formato;

    @Column(name="flg_cifrato")
    private String flgCifrato;

    @Column(name="flg_unico")
    private String flgUnico;

    @Column(name="flg_obbligatorio ")
    private String flgObbligatorio ;

    @Column(name = "default_value")
    private String defaultValue;

    @Column(name = "check_function")
    private String checkFunction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_contesto_applicazione_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_anagAttributiUtenti_tipo_contesto_applicazione"))
    private TipiContestoApplicazioneQueryEntity tipoContestoApplicazione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "share_tipo_contesto_applicazione_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_anagAttributiUtenti_share_tipo_contesto_applicazione"))
    private TipiContestoApplicazioneQueryEntity shareTipoContestoApplicazione;

    @Column(name="version")
    private Long version;

    public AnagAttributiUtentiQueryEntity() {
    }

    public AnagAttributiUtentiQueryEntity(
            @NonNull String id,
            AnagAttributiUtentiBaseDTO dto,
            Long version) {
        this.id = id;
        this.nomeAttributo = dto.getNomeAttributo();
        this.posizione = dto.getPosizione();
        this.tipo = dto.getTipo();
        this.formato = dto.getFormato();
        this.flgCifrato = dto.getFlgCifrato();
        this.flgUnico = dto.getFlgUnico();
        this.flgObbligatorio = dto.getFlgObbligatorio();
        this.defaultValue = dto.getDefaultValue();
        this.checkFunction = dto.getCheckFunction();
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

    public Integer getPosizione() {
        return posizione;
    }

    public void setPosizione(Integer posizione) {
        this.posizione = posizione;
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

    public TipiContestoApplicazioneQueryEntity getTipoContestoApplicazione() {
        return tipoContestoApplicazione;
    }

    public void setTipoContestoApplicazione(TipiContestoApplicazioneQueryEntity tipoContestoApplicazione) {
        this.tipoContestoApplicazione = tipoContestoApplicazione;
    }

    public TipiContestoApplicazioneQueryEntity getShareTipoContestoApplicazione() {
        return shareTipoContestoApplicazione;
    }

    public void setShareTipoContestoApplicazione(TipiContestoApplicazioneQueryEntity shareTipoContestoApplicazione) {
        this.shareTipoContestoApplicazione = shareTipoContestoApplicazione;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
