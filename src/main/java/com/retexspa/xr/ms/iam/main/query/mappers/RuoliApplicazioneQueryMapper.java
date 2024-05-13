package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.RuoliApplicazioneQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliApplicazioneQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface RuoliApplicazioneQueryMapper {
    RuoliApplicazioneQueryMapper INSTANCE = Mappers.getMapper(RuoliApplicazioneQueryMapper.class);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "codice", source = "codice")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "descrizione", source = "descrizione")
    @Mapping(target = "flgAttivo", source = "flgAttivo")
    @Mapping(target = "livelloIam", source = "livelloIam")
    @Mapping(target = "applicazioniId", source = "applicazioni.id")
    @Mapping(target = "version", source = "version")
    RuoliApplicazioneQueryDTO toDTO(RuoliApplicazioneQueryEntity ruoliApplicazioneQueryEntity);

}
