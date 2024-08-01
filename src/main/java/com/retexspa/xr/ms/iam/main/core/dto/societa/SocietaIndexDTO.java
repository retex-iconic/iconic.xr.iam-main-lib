package com.retexspa.xr.ms.iam.main.core.dto.societa;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class SocietaIndexDTO {

  private String societaId;

  public SocietaIndexDTO() {
  }

  public SocietaIndexDTO(String societaId) {
    this.societaId = societaId;
  }

  public static String getIdFromSocieta(String societaId) {
    return UUID.nameUUIDFromBytes(("/SocietaIndex/" + societaId).getBytes()).toString();
  }

  public String getSocietaId() {
    return this.societaId;
  }

  public void setSocietaId(String societaId) {
    this.societaId = societaId;
  }


}
