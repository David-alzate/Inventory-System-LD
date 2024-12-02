package co.inventory.system.ld.application.primaryports.mapper.commons;

import co.inventory.system.ld.application.primaryports.dto.commons.GetIdTypeDTO;
import co.inventory.system.ld.domain.commons.IdTypeDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IdTypeDTOMapper {

    IdTypeDTOMapper INSTANCE = Mappers.getMapper(IdTypeDTOMapper.class);

    IdTypeDomain toDomain(GetIdTypeDTO dto);

    GetIdTypeDTO toDTO(IdTypeDomain domain);

    List<GetIdTypeDTO> toDTOCollection(List<IdTypeDomain> domain);

}
