package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.AnagAttributiRuoliQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.AnagAttributiRuoliQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface AnagAttributiRuoliQueryMapper {

    AnagAttributiRuoliQueryMapper INSTANCE = Mappers.getMapper(AnagAttributiRuoliQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeAttributo", source = "nomeAttributo")
    @Mapping(target = "applicazioneId", source = "applicazione.id")
    @Mapping(target = "shareApplicazioneId", source = "shareApplicazione.id")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "formato", source = "formato")
    @Mapping(target = "posizione", source = "posizione")
    @Mapping(target = "flgCifrato", source = "flgCifrato")
    @Mapping(target = "flgUnico", source = "flgUnico")
    @Mapping(target = "flgObbligatorio", source = "flgObbligatorio")
    @Mapping(target = "defaultValue", source = "defaultValue")
    @Mapping(target = "checkFunction", source = "checkFunction")
    AnagAttributiRuoliQueryDTO toDTO(AnagAttributiRuoliQueryEntity anagAttributiRuoliQueryEntity);

 }
