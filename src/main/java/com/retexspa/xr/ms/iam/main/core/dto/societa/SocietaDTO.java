package com.retexspa.xr.ms.iam.main.core.dto.societa;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SocietaDTO extends SocietaBaseDTO {

    private String id;
  
    public String getId() {
      return id;
    }
  
    public void setId(String id) {
      this.id = id;
    }
  }