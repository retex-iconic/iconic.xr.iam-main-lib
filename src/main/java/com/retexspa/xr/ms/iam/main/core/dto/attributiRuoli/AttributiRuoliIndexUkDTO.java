package com.retexspa.xr.ms.iam.main.core.dto.attributiRuoli;

import com.retexspa.xr.ms.iam.main.core.dto.routing.RoutingIndexUkDTO;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class AttributiRuoliIndexUkDTO  extends AggregateIndexUkBaseDTO {

    public AttributiRuoliIndexUkDTO() {
    }

    public static String getUk(AttributiRuoliBaseDTO attributiRuoliBaseDTO) {
        String uk =  attributiRuoliBaseDTO.getRuoloId() + RoutingIndexUkDTO.getUkSeparator() + attributiRuoliBaseDTO.getAttributoruoloId();
        return uk;
    }

    public static String getIndexName(){
        return "AttributiRuoliIndexUk";
      }
  
      public static String getIndexAggregateName(){
        return "AttributiRuoliIndexUkAggregate";
      }
}
