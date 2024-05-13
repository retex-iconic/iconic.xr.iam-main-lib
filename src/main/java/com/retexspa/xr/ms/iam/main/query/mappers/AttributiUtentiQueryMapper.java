package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.AttributiUtentiQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.AttributiUtentiQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface AttributiUtentiQueryMapper {

    AttributiUtentiQueryMapper INSTANCE = Mappers.getMapper(AttributiUtentiQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "utenteApplicazioneId", source = "utenteApplicazione.id")
    @Mapping(target = "attributoId", source = "attributoUtenti.id")
    @Mapping(target = "contestoId", source = "contestoApplicazione.id")
    @Mapping(target = "valore", source = "valore")
    @Mapping(target = "version", source = "version")
    AttributiUtentiQueryDTO toDTO(AttributiUtentiQueryEntity attributiUtentiQueryEntity);
}
