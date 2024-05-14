package com.retexspa.xr.ms.iam.main.query.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.retexspa.xr.ms.iam.main.core.entities.ApplicazioniQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.ApplicazioniQueryEntity;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface ApplicazioniQueryMapper {

    ApplicazioniQueryMapper INSTANCE = Mappers.getMapper(ApplicazioniQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "codice", source = "codice")
    @Mapping(target = "descrizione", source = "descrizione")
    @Mapping(target = "societaId", source = "societa.id")
    @Mapping(target = "iconicApplicazioniId", source = "iconicApplicazioni.id")
    @Mapping(target = "immagine", source = "immagine")
    @Mapping(target = "flgRuoloUnico", source = "flgRuoloUnico")
    @Mapping(target = "version", source = "version")
    ApplicazioniQueryDTO toDTO(ApplicazioniQueryEntity applicazioniQueryEntity);

}
