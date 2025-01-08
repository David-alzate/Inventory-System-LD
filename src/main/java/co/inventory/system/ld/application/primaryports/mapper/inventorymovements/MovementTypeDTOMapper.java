package co.inventory.system.ld.application.primaryports.mapper.inventorymovements;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.MovementTypeDTO;
import co.inventory.system.ld.domain.inventorymovements.MovementTypeDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovementTypeDTOMapper {
    MovementTypeDTOMapper INSTANCE = Mappers.getMapper(MovementTypeDTOMapper.class);

    MovementTypeDomain toDomain(MovementTypeDTO movementTypeDTO);

    MovementTypeDTO toDTO(MovementTypeDomain movementTypeDomain);

    List<MovementTypeDTO> toDTOCollection(List<MovementTypeDomain> movementTypeDomainList);
}
