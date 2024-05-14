package com.retexspa.xr.ms.iam.main.query.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.retexspa.xr.ms.iam.main.core.entities.RoutingQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.RoutingQueryEntity;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface RoutingQueryMapper {

    RoutingQueryMapper INSTANCE = Mappers.getMapper(RoutingQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "routingCharId", source = "routingCharId")
    @Mapping(target = "titolo", source = "titolo")
    @Mapping(target = "urlLink", source = "urlLink")
    @Mapping(target = "iconicApplicazioniId", source = "iconicApplicazioni.id")
    @Mapping(target = "icone", source = "icone")
    @Mapping(target = "subtitolo", source = "subtitolo")
    @Mapping(target = "flgGdpr", source = "flgGdpr")
    @Mapping(target = "nodoId", source = "nodo.id")
    @Mapping(target = "version", source = "version")
    RoutingQueryDTO toDTO(RoutingQueryEntity routingQueryEntity);

}
