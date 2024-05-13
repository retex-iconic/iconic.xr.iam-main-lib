package com.retexspa.xr.ms.iam.main.query.mappers;


import com.retexspa.xr.ms.iam.main.core.entities.UtentiApplicazioniQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.UtentiApplicazioniQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface UtentiApplicazioniQueryMapper {

    UtentiApplicazioniQueryMapper INSTANCE = Mappers.getMapper(UtentiApplicazioniQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "flgAcquisizioneAuto", source = "flgAcquisizioneAuto")
    @Mapping(target = "dataFineValidita", source = "dataFineValidita")
    @Mapping(target = "dataInizioValidita", source = "dataInizioValidita")
    @Mapping(target = "ruoloId", source = "ruolo.id")
    @Mapping(target = "contestoId", source = "contesto.id")
    @Mapping(target = "utenteId", source = "utente.id")
    UtentiApplicazioniQueryDTO toDTO(UtentiApplicazioniQueryEntity badgeSocietaQueryEntity);

   }
