package com.retexspa.xr.ms.iam.main.query.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.retexspa.xr.ms.iam.main.core.dto.societa.SocietaBaseDTO;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;

@Entity
@Table(name = "societa", uniqueConstraints = {
    @UniqueConstraint(name = "societa_uk", columnNames = { "codice" })
})
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

  @Column(name = "version")
  private Long version;

  //foreing key
  @ManyToOne(optional = true, fetch = FetchType.EAGER)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_societa_gerarchia"))
  private GerarchiaQueryEntity gerarchia;

  //master detail
  // @OneToMany( fetch = FetchType.EAGER, mappedBy = "societa")
  // @JsonIgnore
  // private Set<ApplicazioniQueryEntity>  applicazioni;

  // @OneToMany( fetch = FetchType.EAGER, mappedBy = "societa")
  // @JsonIgnore
  // private Set<UtentiSocietaQueryEntity>  utentiSocieta;

  // @OneToMany( fetch = FetchType.EAGER, mappedBy = "societa")
  // @JsonIgnore
  // private Set<BadgeSocietaQueryEntity>  badgeSocieta;


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

  public Set<ApplicazioniQueryEntity> getApplicazioni() {
    return applicazioni;
  }

  public void setApplicazioni(Set<ApplicazioniQueryEntity> applicazioni) {
    this.applicazioni = applicazioni;
  }

  

}
