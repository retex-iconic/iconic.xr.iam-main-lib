package com.retexspa.xr.ms.iam.main.core.dto.utentiApplicazioni;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class UtentiApplicazioniIndexUkDTO extends AggregateIndexUkBaseDTO {

    public UtentiApplicazioniIndexUkDTO() {
    }

    public static String getUk(UtentiApplicazioniBaseDTO utentiApplicazioni) {
        String uk =  utentiApplicazioni.getUtenteId() +
                UtentiApplicazioniIndexUkDTO.getUkSeparator() +
                utentiApplicazioni.getContestoId() +
                UtentiApplicazioniIndexUkDTO.getUkSeparator() +
                utentiApplicazioni.getRuoloId();
        return uk;
    }


    public static String getIndexName(){
        return "UtentiApplicazioniIndexUk";
      }
  
      public static String getIndexAggregateName(){
        return "UtentiApplicazioniIndexUkAggregate";
      }
}
