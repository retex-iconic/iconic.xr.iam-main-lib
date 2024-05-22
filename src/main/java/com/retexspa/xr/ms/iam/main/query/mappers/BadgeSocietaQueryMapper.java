package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.BadgeSocietaQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.BadgeSocietaQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface BadgeSocietaQueryMapper {

    BadgeSocietaQueryMapper INSTANCE = Mappers.getMapper(BadgeSocietaQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "codiceBadge", source = "codiceBadge")
    @Mapping(target = "pwd", source = "pwd")
    @Mapping(target = "tipoBadge", source = "tipoBadge")
    @Mapping(target = "societaId", source = "societa.id")
    @Mapping(target = "version", source = "version")
    BadgeSocietaQueryDTO toDTO(BadgeSocietaQueryEntity badgeSocietaQueryEntity);

}
