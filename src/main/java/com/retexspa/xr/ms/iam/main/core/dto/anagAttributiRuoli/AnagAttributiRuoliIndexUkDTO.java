package com.retexspa.xr.ms.iam.main.core.dto.anagAttributiRuoli;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class AnagAttributiRuoliIndexUkDTO extends AggregateIndexUkBaseDTO {

    public AnagAttributiRuoliIndexUkDTO() {
    }

    public static String getUk(AnagAttributiRuoliBaseDTO anagAttributiUtenti) {
        return anagAttributiUtenti.getNomeAttributo() +
                AnagAttributiRuoliIndexUkDTO.getUkSeparator() +
                anagAttributiUtenti.getApplicazioneId();
    }

    public static String getIndexName(){
        return "AnagAttributiRuoliIndexUk";
      }
  
      public static String getIndexAggregateName(){
        return "AnagAttributiRuoliIndexUkAggregate";
      }

}
