package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.tipiContesto.TipiContestoBaseDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipiContesto")
public class TipiContestoQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codice")
    private String codice;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name="version")
    private Long version;

    @Column(name="flgGerarchia")
    private String flgGerarchia;

    public TipiContestoQueryEntity() {
    }

    public TipiContestoQueryEntity(@NotNull String id, TipiContestoBaseDTO dto, Long version) {
        this.id = id;
        this.descrizione = dto.getDescrizione();
        this.nome = dto.getNome();
        this.codice = dto.getCodice();
        this.version = version;
        this.flgGerarchia = dto.getFlgGerarchia();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFlgGerarchia() {
        return flgGerarchia;
    }

    public void setFlgGerarchia(String flgGerarchia) {
        this.flgGerarchia = flgGerarchia;
    }
}
