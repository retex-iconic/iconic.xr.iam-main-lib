package com.retexspa.xr.ms.iam.main.core.dto.ruoliRouting;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class RuoliRoutingIndexUkDTO extends AggregateIndexUkBaseDTO {

    public RuoliRoutingIndexUkDTO() {
    }

    public static String getUk(RuoliRoutingBaseDTO ruoliRouting) {
        String uk =  ruoliRouting.getRoutingId() + RuoliRoutingIndexUkDTO.getUkSeparator() + ruoliRouting.getRuoloId();
        return uk;
    }


    public static String getIndexName(){
        return "RuoliRoutingIndexUk";
      }
  
      public static String getIndexAggregateName(){
        return "RuoliRoutingIndexUkAggregate";
      }
}
