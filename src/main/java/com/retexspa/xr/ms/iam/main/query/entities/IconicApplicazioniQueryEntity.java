package com.retexspa.xr.ms.iam.main.query.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.retexspa.xr.ms.iam.main.core.dto.iconicApplicazioni.IconicApplicazioniBaseDTO;
@Entity
@Table(name = "iconic_applicazioni",
 uniqueConstraints = {
    @UniqueConstraint(name = "iconic_applicazioni_uk", columnNames = {  "codice" })
})
public class IconicApplicazioniQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codice")
    private String codice;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "subtitolo")
    private String subtitolo;

    @Column(name = "url")
    private String url;

    @Column(name="immagine")
    private String immagine;

    @Column(name="version")
    private Long version;

    public IconicApplicazioniQueryEntity() {
    }    


    public IconicApplicazioniQueryEntity(String id, String nome, String codice, String descrizione, String titolo,
            String subtitolo, String url, String immagine) {
        this.id = id;
        this.nome = nome;
        this.codice = codice;
        this.descrizione = descrizione;
        this.titolo = titolo;
        this.subtitolo = subtitolo;
        this.url = url;
        this.immagine = immagine;
    }
    public IconicApplicazioniQueryEntity(@NotNull String id, IconicApplicazioniBaseDTO dto, Long version) {
        this.id = id;
        this.descrizione = dto.getDescrizione();
        this.nome = dto.getNome();
        this.codice = dto.getCodice();
        this.titolo = dto.getTitolo();
        this.subtitolo = dto.getSubtitolo();
        this.url = dto.getUrl();
        this.immagine = dto.getImmagine();
        this.version = version;
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

    public String getImmagine() {
        return immagine;
    }


    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }


    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getSubtitolo() {
        return subtitolo;
    }

    public void setSubtitolo(String subtitolo) {
        this.subtitolo = subtitolo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    
}
