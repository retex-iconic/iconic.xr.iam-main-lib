package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.TipiContestoApplicazioneQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.TipiContestoApplicazioneQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface TipiContestoApplicazioneQueryMapper {

    TipiContestoApplicazioneQueryMapper INSTANCE = Mappers.getMapper(TipiContestoApplicazioneQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "applicazioneId", source = "applicazione.id")
    @Mapping(target = "tipiContestoId", source = "tipiContesto.id")
    @Mapping(target = "version", source = "version")
    @Mapping(target = "tassonomiaId", source = "tassonomiaId")
    TipiContestoApplicazioneQueryDTO toDTO(TipiContestoApplicazioneQueryEntity tipiContestoApplicazioneQueryEntity);

}
