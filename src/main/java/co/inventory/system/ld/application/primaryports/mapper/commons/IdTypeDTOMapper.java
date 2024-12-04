package co.inventory.system.ld.application.primaryports.mapper.commons;

import co.inventory.system.ld.application.primaryports.dto.commons.IdTypeDTO;
import co.inventory.system.ld.domain.commons.IdTypeDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IdTypeDTOMapper {

    IdTypeDTOMapper INSTANCE = Mappers.getMapper(IdTypeDTOMapper.class);

    IdTypeDomain toDomain(IdTypeDTO dto);

    IdTypeDTO toDTO(IdTypeDomain domain);

    List<IdTypeDTO> toDTOCollection(List<IdTypeDomain> domain);

}
