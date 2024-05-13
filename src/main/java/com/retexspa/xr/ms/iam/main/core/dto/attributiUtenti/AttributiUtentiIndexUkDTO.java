package com.retexspa.xr.ms.iam.main.core.dto.attributiUtenti;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class AttributiUtentiIndexUkDTO extends AggregateIndexUkBaseDTO {

    public AttributiUtentiIndexUkDTO() {
    }

    public static String getUk(AttributiUtentiBaseDTO attributiUtenti) {
        String uk =  attributiUtenti.getUtenteApplicazioneId() + AttributiUtentiIndexUkDTO.getUkSeparator() + attributiUtenti.getAttributoId()+ AttributiUtentiIndexUkDTO.getUkSeparator() + attributiUtenti.getContestoId() ;
        return uk;
    }

    public static String getIndexName(){
        return "AttributiUtentiIndexUk";
      }
  
      public static String getIndexAggregateName(){
        return "AttributiUtentiIndexUkAggregate";
      }
}
