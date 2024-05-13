package com.retexspa.xr.ms.iam.main.core.dto.ruoliNotifiche;

import com.retexspa.xr.ms.iam.main.core.dto.routing.RoutingIndexUkDTO;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class RuoliNotificheIndexUkDTO extends AggregateIndexUkBaseDTO {
 public  RuoliNotificheIndexUkDTO() {}
    public static String getUk(RuoliNotificheBaseDTO ruoliNotifiche) {
        String uk =  ruoliNotifiche.getNotificaId() + RoutingIndexUkDTO.getUkSeparator() + ruoliNotifiche.getRuoloId();
        return uk;
    }


    public static String getIndexName() {
        return "RuoliNotificheIndexUk";
    }

    public static String getIndexAggregateName() {
        return "RuoliNotificheIndexUkAggregate";
    }
}
