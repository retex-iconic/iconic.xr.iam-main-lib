package com.retexspa.xr.ms.iam.main.core.dto.contestiApplicazioni;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class ContestiApplicazioniIndexUkDTO extends AggregateIndexUkBaseDTO {

    public ContestiApplicazioniIndexUkDTO() {
    }

    public static String getUk(ContestiApplicazioniBaseDTO contestiApplicazioni) {
        String uk =  contestiApplicazioni.getCodice() +
                ContestiApplicazioniIndexUkDTO.getUkSeparator() +
                contestiApplicazioni.getTipoContestoApplicazioneId();
        return uk;
    }

    public static String getIndexName(){
        return "ContestiApplicazioniIndexUk";
      }
  
      public static String getIndexAggregateName(){
        return "ContestiApplicazioniIndexUkAggregate";
      }
}
