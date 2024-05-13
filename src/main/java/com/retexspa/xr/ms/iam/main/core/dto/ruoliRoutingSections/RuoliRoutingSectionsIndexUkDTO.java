package com.retexspa.xr.ms.iam.main.core.dto.ruoliRoutingSections;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class RuoliRoutingSectionsIndexUkDTO extends AggregateIndexUkBaseDTO {

    public RuoliRoutingSectionsIndexUkDTO() {
    }

    public static String getUk(RuoliRoutingSectionsBaseDTO ruoliRoutingSections) {
        String uk =  ruoliRoutingSections.getRuoliRoutingId() + RuoliRoutingSectionsIndexUkDTO.getUkSeparator() + ruoliRoutingSections.getRoutingSectionId();
        return uk;
    }

    public static String getIndexName(){
        return "RuoliRoutingSectionsIndexUk";
      }
  
      public static String getIndexAggregateName(){
        return "RuoliRoutingSectionsIndexUkAggregate";
      }



}
