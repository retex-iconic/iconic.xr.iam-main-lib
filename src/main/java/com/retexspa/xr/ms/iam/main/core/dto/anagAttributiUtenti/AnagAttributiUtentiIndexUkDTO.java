package com.retexspa.xr.ms.iam.main.core.dto.anagAttributiUtenti;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class AnagAttributiUtentiIndexUkDTO extends AggregateIndexUkBaseDTO {

    public AnagAttributiUtentiIndexUkDTO() {
    }

    public static String getUk(AnagAttributiUtentiBaseDTO anagAttributiUtenti) {
        return anagAttributiUtenti.getNomeAttributo() +
                AnagAttributiUtentiIndexUkDTO.getUkSeparator() +
                anagAttributiUtenti.getTipoContestoApplicazioneId();
    }
    public static String getIndexName(){
        return "AnagAttributiUtentiIndexUk";
      }
  
      public static String getIndexAggregateName(){
        return "AnagAttributiUtentiIndexUkAggregate";
      }


}
