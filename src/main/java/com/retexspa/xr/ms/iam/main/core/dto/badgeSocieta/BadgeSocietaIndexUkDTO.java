package com.retexspa.xr.ms.iam.main.core.dto.badgeSocieta;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class BadgeSocietaIndexUkDTO  extends AggregateIndexUkBaseDTO {

    public BadgeSocietaIndexUkDTO() {
    }

    public static String getUk(BadgeSocietaBaseDTO badgeSocieta) {
        String uk = badgeSocieta.getCodiceBadge() +
                BadgeSocietaIndexUkDTO.getUkSeparator() +
                badgeSocieta.getSocietaId();
        return uk;
    }

    public static String getIndexName(){
        return "BadgeSocietaIndexUk";
      }
  
      public static String getIndexAggregateName(){
        return "BadgeSocietaIndexUkAggregate";
      }
}


