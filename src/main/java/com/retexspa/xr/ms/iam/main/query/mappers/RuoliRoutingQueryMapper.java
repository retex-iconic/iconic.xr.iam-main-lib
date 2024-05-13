package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.RuoliRoutingQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliRoutingQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface RuoliRoutingQueryMapper {
    RuoliRoutingQueryMapper INSTANCE = Mappers.getMapper(RuoliRoutingQueryMapper.class);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "routingId", source = "routing.id")
    @Mapping(target = "ruoloId", source = "ruolo.id")
    @Mapping(target = "flgAttiva", source = "flgAttiva")
    @Mapping(target = "flgReadonly", source = "flgReadonly")
    @Mapping(target = "flgInsert", source = "flgInsert")
    @Mapping(target = "flgUpdate", source = "flgUpdate")
    @Mapping(target = "flgDelete", source = "flgDelete")
    @Mapping(target = "version", source = "version")
    RuoliRoutingQueryDTO toDTO(RuoliRoutingQueryEntity ruoliRoutingQueryEntity);
}
