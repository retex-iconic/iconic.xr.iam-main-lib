package com.retexspa.xr.ms.iam.main.core.dto.iconicApplicazioni;

import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class IconicApplicazioniIndexUkDTO extends AggregateIndexUkBaseDTO {

    public IconicApplicazioniIndexUkDTO() {
    }

    public static String getUk(IconicApplicazioniBaseDTO iconicApplicazioni) {
        String uk =  iconicApplicazioni.getCodice();
        return uk;
    }

    public static String getIndexName(){
        return "IconicApplicazioniIndexUk";
    }

    public static String getIndexAggregateName(){
        return "IconicApplicazioniIndexUkAggregate";
    }
}
