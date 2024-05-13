package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.MenuQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.MenuQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface MenuQueryMapper {
    MenuQueryMapper INSTANCE = Mappers.getMapper(MenuQueryMapper.class);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "menuCharId", source = "menuCharId")
    @Mapping(target = "routingId", source = "routing.id")
    @Mapping(target = "ordinamento", source = "ordinamento")
    @Mapping(target = "icone", source = "icone")
    @Mapping(target = "queryParams", source = "queryParams")
    @Mapping(target = "titolo", source = "titolo")
    @Mapping(target = "flgAttiva", source = "flgAttiva")
    @Mapping(target = "homePagina", source = "homePagina")
    @Mapping(target = "tipoMenu", source = "tipoMenu")
    @Mapping(target = "idMenu", source = "idMenu")
    @Mapping(target = "pidMenu", source = "pidMenu")
    @Mapping(target = "nodoId", source = "nodo.id")
    @Mapping(target = "version", source = "version")
    MenuQueryDTO toDTO(MenuQueryEntity menuQueryEntity);
}
