package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.ContestiApplicazioniQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.ContestiApplicazioniQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface ContestiApplicazioniQueryMapper {

    ContestiApplicazioniQueryMapper INSTANCE = Mappers.getMapper(ContestiApplicazioniQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "codice", source = "codice")
    @Mapping(target = "descrizione", source = "descrizione")
    @Mapping(target = "tipoContestoApplicazioneId", source = "tipoContestoApplicazione.id")
    @Mapping(target = "flgAcquisizioneAuto", source = "flgAcquisizioneAuto")
    @Mapping(target = "version", source = "version")
    ContestiApplicazioniQueryDTO toDTO(ContestiApplicazioniQueryEntity contestiApplicazioniQueryEntity);

}