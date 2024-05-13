package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.AttributiRuoliQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.AttributiRuoliQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface AttributiRuoliQueryMapper {

    AttributiRuoliQueryMapper INSTANCE = Mappers.getMapper(AttributiRuoliQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "ruoloId", source = "ruolo.id")
    @Mapping(target = "attributoruoloId", source = "attributoRuolo.id")
    @Mapping(target = "valore", source = "valore")
    AttributiRuoliQueryDTO toDTO(AttributiRuoliQueryEntity attributiRuoliQueryEntity);

 }
