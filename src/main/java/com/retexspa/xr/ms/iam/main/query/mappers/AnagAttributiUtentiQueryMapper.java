package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.AnagAttributiUtentiQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.AnagAttributiUtentiQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface AnagAttributiUtentiQueryMapper {

    AnagAttributiUtentiQueryMapper INSTANCE = Mappers.getMapper(AnagAttributiUtentiQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeAttributo", source = "nomeAttributo")
    @Mapping(target = "posizione", source = "posizione")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "formato", source = "formato")
    @Mapping(target = "flgCifrato", source = "flgCifrato")
    @Mapping(target = "flgUnico", source = "flgUnico")
    @Mapping(target = "flgObbligatorio", source = "flgObbligatorio")
    @Mapping(target = "defaultValue", source = "defaultValue")
    @Mapping(target = "checkFunction", source = "checkFunction")
    @Mapping(target = "tipoContestoApplicazioneId", source = "tipoContestoApplicazione.id")
    @Mapping(target = "shareTipoContestoApplicazioneId", source = "shareTipoContestoApplicazione.id")
    @Mapping(target = "version", source = "version")
    AnagAttributiUtentiQueryDTO toDTO(AnagAttributiUtentiQueryEntity anagAttributiUtentiQueryEntity);

}
