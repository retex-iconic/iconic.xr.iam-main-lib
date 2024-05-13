package com.retexspa.xr.ms.iam.main.core.dto.societa;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class SocietaIndexUkDTO extends AggregateIndexUkBaseDTO {

    public SocietaIndexUkDTO() {
    }

    public static String getUk(SocietaBaseDTO societa) {
        String uk = societa.getCodice();
        return uk;
      }

public static String getIndexName(){
      return "SocietaIndexUk";
    }

    public static String getIndexAggregateName(){
      return "SocietaIndexUkAggregate";
    }





}
