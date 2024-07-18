package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.SostituzioniBadgeQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.SostituzioniBadgeQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface SostituzioniBadgeQueryMapper {
    SostituzioniBadgeQueryMapper INSTANCE = Mappers.getMapper(SostituzioniBadgeQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "causale", source = "causale")
    @Mapping(target = "dataRiconsegna", source = "dataRiconsegna")
    @Mapping(target = "dataBlocco", source = "dataBlocco")
    @Mapping(target = "dataSblocco", source = "dataSblocco")
    @Mapping(target = "dataAssegnazione", source = "dataAssegnazione")
    @Mapping(target = "badgeId", source = "badge.id")
    @Mapping(target = "utentiId", source = "utenti.id")
    @Mapping(target = "version", source = "version")
    SostituzioniBadgeQueryDTO toDTO(SostituzioniBadgeQueryEntity sostituzioniBadgeQueryEntity);

  }
