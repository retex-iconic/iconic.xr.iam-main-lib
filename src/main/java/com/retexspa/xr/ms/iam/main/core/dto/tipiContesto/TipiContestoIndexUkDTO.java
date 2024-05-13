package com.retexspa.xr.ms.iam.main.core.dto.tipiContesto;

import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class TipiContestoIndexUkDTO extends AggregateIndexUkBaseDTO {

    public TipiContestoIndexUkDTO() {
    }

    public static String getUk(TipiContestoBaseDTO tipiContesto) {
        String uk = tipiContesto.getCodice();
        return uk;
    }

    public static String getIndexName(){
      return "TipiContestoIndexUk";
    }

    public static String getIndexAggregateName(){
      return "TipiContestoIndexUkAggregate";
    }
    
}
