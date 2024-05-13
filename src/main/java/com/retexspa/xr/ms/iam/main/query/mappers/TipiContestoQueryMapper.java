package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.TipiContestoQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.TipiContestoQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface TipiContestoQueryMapper {

    TipiContestoQueryMapper INSTANCE = Mappers.getMapper(TipiContestoQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "codice", source = "codice")
    @Mapping(target = "descrizione", source = "descrizione")
    @Mapping(target = "flgGerarchia", source = "flgGerarchia")
    @Mapping(target = "version", source = "version")
    TipiContestoQueryDTO toDTO(TipiContestoQueryEntity tipiContestoQueryEntity);

}
