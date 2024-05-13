package com.retexspa.xr.ms.iam.main.core.dto.notifiche;

import com.retexspa.xr.ms.iam.main.core.dto.routing.RoutingIndexUkDTO;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class NotificheIndexUkDTO extends AggregateIndexUkBaseDTO {

    public NotificheIndexUkDTO() {
    }

    public static String getUk(NotificheBaseDTO notifiche) {
        String uk =  notifiche.getApplicazioneId() + RoutingIndexUkDTO.getUkSeparator() + notifiche.getCodice();
        return uk;
    }

    public static String getIndexName() {
        return "NotificheIndexUk";
    }

    public static String getIndexAggregateName() {
        return "NotificheIndexUkAggregate";
    }


}
