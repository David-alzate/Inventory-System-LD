package co.inventory.system.ld.application.primaryports.mapper.commons;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.primaryports.dto.commons.GetStatusDTO;
import co.inventory.system.ld.domain.commons.StatusDomain;

@Mapper
public interface StatusDTOMapper {
	
	StatusDTOMapper INSTANCE = Mappers.getMapper(StatusDTOMapper.class);

    StatusDomain toDomain(GetStatusDTO dto);

    GetStatusDTO toDTO(StatusDomain domain);

    List<GetStatusDTO> toDTOCollection(List<StatusDomain> domain);

}
