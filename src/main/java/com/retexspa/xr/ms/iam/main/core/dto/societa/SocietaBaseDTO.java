package com.retexspa.xr.ms.iam.main.core.dto.societa;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SocietaBaseDTO {

    @NotNull(message = "codice is mandatory")
    @NotEmpty(message = "codice is mandatory")
    @NotBlank(message = "codice is mandatory")
    private String codice;
  
    @NotNull(message = "nome is mandatory")
    private String nome;
  
    @NotNull(message = "descrizione is mandatory")
    private String descrizione;

    private String gerarchiaId;    

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getGerarchiaId() {
        return gerarchiaId;
    }

    public void setGerarchiaId(String gerarchiaId) {
        this.gerarchiaId = gerarchiaId;
    }

    @JsonIgnore
    public String getAggregateId() {
      return UUID.randomUUID().toString();
    }

    public static String getAggregateName() {
        return "SocietaAggregate";
    }

    public static String getName() {
        return "Societa";
    }
}
