package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.SocietaQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.SocietaQueryEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

/*

Create all the target properties in ArticoloDTO and ArticoloQueryEntity

 only fields with block comment as prefix  are required

 */

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface SocietaQueryMapper {

  SocietaQueryMapper INSTANCE = Mappers.getMapper(SocietaQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "version", source = "version")
  SocietaQueryDTO toDTO(SocietaQueryEntity societaQueryEntity);

}
