package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.RoutingSectionsQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.RoutingSectionsQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface RoutingSectionsQueryMapper {

    RoutingSectionsQueryMapper INSTANCE = Mappers.getMapper(RoutingSectionsQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "codice", source = "codice")
    @Mapping(target = "descrizione", source = "descrizione")
    @Mapping(target = "routingId", source = "routing.id")
    @Mapping(target = "version", source = "version")
    RoutingSectionsQueryDTO toDTO(RoutingSectionsQueryEntity routingSectionsQueryEntity);

}