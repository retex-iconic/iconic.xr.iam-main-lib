package com.retexspa.xr.ms.iam.main.core.dto.routingSections;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class RoutingSectionsIndexUkDTO extends AggregateIndexUkBaseDTO {

    public RoutingSectionsIndexUkDTO() {
    }

    public static String getUk(RoutingSectionsBaseDTO routingSections) {
        String uk =  routingSections.getRoutingId() + RoutingSectionsIndexUkDTO.getUkSeparator() + routingSections.getCodice();
        return uk;
    }

    public static String getIndexName(){
        return "RoutingSectionsIndexUk";
    }

    public static String getIndexAggregateName(){
        return "RoutingSectionsIndexUkAggregate";
    }
}
