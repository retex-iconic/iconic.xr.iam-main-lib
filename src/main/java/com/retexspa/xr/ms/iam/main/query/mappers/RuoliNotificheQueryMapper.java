package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.RuoliNotificheQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliNotificheQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface RuoliNotificheQueryMapper {
    RuoliNotificheQueryMapper INSTANCE = Mappers.getMapper(RuoliNotificheQueryMapper.class);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "notificaId", source = "notifica.id")
    @Mapping(target = "ruoloId", source = "ruolo.id")
    @Mapping(target = "version", source = "version")
    RuoliNotificheQueryDTO toDTO(RuoliNotificheQueryEntity ruoliNotificheQueryEntity);
}
