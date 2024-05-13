package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.RuoliRoutingSectionsQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliRoutingSectionsQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface RuoliRoutingSectionsQueryMapper {
    RuoliRoutingSectionsQueryMapper INSTANCE = Mappers.getMapper(RuoliRoutingSectionsQueryMapper.class);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "ruoliRoutingId", source = "ruoliRouting.id")
    @Mapping(target = "routingSectionId", source = "routingSection.id")
    @Mapping(target = "flgAttiva", source = "flgAttiva")
    @Mapping(target = "flgReadonly", source = "flgReadonly")
    @Mapping(target = "flgInsert", source = "flgInsert")
    @Mapping(target = "flgUpdate", source = "flgUpdate")
    @Mapping(target = "flgDelete", source = "flgDelete")
    @Mapping(target = "version", source = "version")
    RuoliRoutingSectionsQueryDTO toDTO(RuoliRoutingSectionsQueryEntity ruoliRoutingSectionsQueryEntity);
}
