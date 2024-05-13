package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.NotificheQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.NotificheQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface NotificheQueryMapper {
    NotificheQueryMapper INSTANCE = Mappers.getMapper(NotificheQueryMapper.class);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "codice", source = "codice")
    @Mapping(target = "titolo", source = "titolo")
    @Mapping(target = "dettaglio", source = "dettaglio")
    @Mapping(target = "icone", source = "icone")
    @Mapping(target = "flgAttiva", source = "flgAttiva")
    @Mapping(target = "routingId", source = "routing.id")
    @Mapping(target = "applicazioneId", source = "applicazione.id")
    @Mapping(target = "version", source = "version")
    NotificheQueryDTO toDTO(NotificheQueryEntity notificheQueryEntity);
}

