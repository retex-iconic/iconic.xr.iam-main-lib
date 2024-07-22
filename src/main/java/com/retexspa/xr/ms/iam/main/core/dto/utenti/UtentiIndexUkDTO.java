package com.retexspa.xr.ms.iam.main.core.dto.utenti;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class UtentiIndexUkDTO extends AggregateIndexUkBaseDTO {

    public UtentiIndexUkDTO() {
    }

    public static String getUk(UtentiBaseDTO utentiSocieta) {
        String uk = utentiSocieta.getIdAccount();
        return uk;
    }

    public static String getIndexName(){
        return "UtentiIndexUk";
    }

    public static String getIndexAggregateName(){
        return "UtentiIndexUkAggregate";
    }
}
