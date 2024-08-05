package com.retexspa.xr.ms.iam.main.query.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.retexspa.xr.ms.iam.main.core.entities.IconicApplicazioniQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.IconicApplicazioniQueryEntity;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface IconicApplicazioniQueryMapper {

    IconicApplicazioniQueryMapper INSTANCE = Mappers.getMapper(IconicApplicazioniQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "codice", source = "codice")
    @Mapping(target = "descrizione", source = "descrizione")
    @Mapping(target = "immagine", source = "immagine")
    @Mapping(target = "version", source = "version")
    IconicApplicazioniQueryDTO toDTO(IconicApplicazioniQueryEntity iconicApplicazioniQueryEntity);

}
