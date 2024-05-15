package com.retexspa.xr.ms.iam.main.query.mappers;

import com.retexspa.xr.ms.iam.main.core.entities.UtentiSocietaQueryDTO;
import com.retexspa.xr.ms.iam.main.query.entities.UtentiSocietaQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface UtentiSocietaQueryMapper {
    UtentiSocietaQueryMapper INSTANCE = Mappers.getMapper(UtentiSocietaQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "idAccount", source = "idAccount")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "cognome", source = "cognome")
    @Mapping(target = "dataInizioValidita", source = "dataInizioValidita")
    @Mapping(target = "dataFineValidita", source = "dataFineValidita")
    @Mapping(target = "matricola", source = "matricola")
    @Mapping(target = "badgeId", source = "badge.id")
    @Mapping(target = "statoBadge", source = "statoBadge")
    @Mapping(target = "codiceFiscale", source = "codiceFiscale")
    @Mapping(target = "indirrizoEmail", source = "indirrizoEmail")
    @Mapping(target = "upn", source = "upn")
    @Mapping(target = "pwd", source = "pwd")
    @Mapping(target = "societaId", source = "societa.id")
    @Mapping(target = "version", source = "version")
    UtentiSocietaQueryDTO toDTO(UtentiSocietaQueryEntity societaQueryEntity);

}
