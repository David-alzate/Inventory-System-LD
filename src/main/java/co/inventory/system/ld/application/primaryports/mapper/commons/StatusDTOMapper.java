package co.inventory.system.ld.application.primaryports.mapper.commons;

import java.util.List;

import co.inventory.system.ld.application.primaryports.dto.commons.StatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.domain.commons.StatusDomain;

@Mapper
public interface StatusDTOMapper {
	
	StatusDTOMapper INSTANCE = Mappers.getMapper(StatusDTOMapper.class);

    StatusDomain toDomain(StatusDTO dto);

    StatusDTO toDTO(StatusDomain domain);

    List<StatusDTO> toDTOCollection(List<StatusDomain> domain);

}
