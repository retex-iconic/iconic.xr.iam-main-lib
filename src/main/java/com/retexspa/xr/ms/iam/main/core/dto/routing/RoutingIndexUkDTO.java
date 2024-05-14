package com.retexspa.xr.ms.iam.main.core.dto.routing;

import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class RoutingIndexUkDTO extends AggregateIndexUkBaseDTO {

    public RoutingIndexUkDTO() {
    }

    public static String getUk(RoutingBaseDTO routing) {
        String uk = routing.getRoutingCharId() + RoutingIndexUkDTO.getUkSeparator() + routing.getIconicApplicazioniId();
        return uk;
    }

    public static String getIndexName() {
        return "RoutingIndexUk";
    }

    public static String getIndexAggregateName() {
        return "RoutingIndexUkAggregate";
    }

}
