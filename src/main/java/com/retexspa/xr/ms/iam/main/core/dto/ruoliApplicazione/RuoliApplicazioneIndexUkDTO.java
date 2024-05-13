package com.retexspa.xr.ms.iam.main.core.dto.ruoliApplicazione;

import com.retexspa.xr.ms.iam.main.core.dto.utentiSocieta.UtentiSocietaIndexUkDTO;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class RuoliApplicazioneIndexUkDTO extends AggregateIndexUkBaseDTO {

    public RuoliApplicazioneIndexUkDTO() {
    }

    public static String getUk(RuoliApplicazioneBaseDTO baseDTO) {
        String uk = baseDTO.getCodice() +
                UtentiSocietaIndexUkDTO.getUkSeparator() +
                baseDTO.getApplicazioniId();
        return uk;
    }


    public static String getIndexName(){
        return "RuoliApplicazioneIndexUk";
      }
  
      public static String getIndexAggregateName(){
        return "RuoliApplicazioneIndexUkAggregate";
      }

}
