package com.retexspa.xr.ms.iam.main.core.dto.tipiContestoApplicazione;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

public class TipiContestoApplicazioneIndexUkDTO extends AggregateIndexUkBaseDTO {

  public TipiContestoApplicazioneIndexUkDTO() {
  }

  public static String getUk(TipiContestoApplicazioneBaseDTO tipiContestoApplicazione) {
    String uk = tipiContestoApplicazione.getApplicazioneId() +
        TipiContestoApplicazioneIndexUkDTO.getUkSeparator() +
        tipiContestoApplicazione.getTipiContestoId() +
        TipiContestoApplicazioneIndexUkDTO.getUkSeparator() +
        tipiContestoApplicazione.getTassonomiaId();
    return uk;
  }

  public static String getIndexName() {
    return "TipiContestoApplicazioneIndexUk";
  }

  public static String getIndexAggregateName() {
    return "TipiContestoApplicazioneIndexUkAggregate";
  }

}
