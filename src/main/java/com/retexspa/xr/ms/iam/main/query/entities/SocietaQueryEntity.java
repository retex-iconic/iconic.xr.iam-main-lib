package com.retexspa.xr.ms.iam.main.query.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.iam.main.core.dto.societa.SocietaBaseDTO;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "societa")
public class SocietaQueryEntity {

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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id")
  private GerarchiaQueryEntity gerarchia;

  public SocietaQueryEntity() {
  }  

  public SocietaQueryEntity(@NotNull String id, SocietaBaseDTO dto, Long version) {
    this.id = id;
    this.descrizione = dto.getDescrizione();
    this.nome = dto.getNome();
    this.codice = dto.getCodice();
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


  public Long getVersion() {
    return version;
  }


  public void setVersion(Long version) {
    this.version = version;
  }


  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }


  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  

 
}
