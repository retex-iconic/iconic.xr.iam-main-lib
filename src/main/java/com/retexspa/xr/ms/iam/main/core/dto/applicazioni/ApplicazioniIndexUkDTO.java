package com.retexspa.xr.ms.iam.main.core.dto.applicazioni;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class ApplicazioniIndexUkDTO extends AggregateIndexUkBaseDTO {

    public ApplicazioniIndexUkDTO() {
    }

    public static String getUk(ApplicazioniBaseDTO applicazioni) {
        String uk =  applicazioni.getCodice() + ApplicazioniIndexUkDTO.getUkSeparator() + applicazioni.getSocietaId();
        return uk;
    }

    public static String getIndexName(){
        return "ApplicazioniIndexUk";
    }

    public static String getIndexAggregateName(){
        return "ApplicazioniIndexUkAggregate";
    }
}
