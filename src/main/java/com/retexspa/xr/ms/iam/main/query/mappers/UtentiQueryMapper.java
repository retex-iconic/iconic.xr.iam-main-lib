package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.UtentiQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.UtentiQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface UtentiQueryMapper {
    UtentiQueryMapper INSTANCE = Mappers.getMapper(UtentiQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "idAccount", source = "idAccount")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "cognome", source = "cognome")
    @Mapping(target = "codiceFiscale", source = "codiceFiscale")
    @Mapping(target = "version", source = "version")
    UtentiQueryDTO toDTO(UtentiQueryEntity QueryEntity);

}
