package co.inventory.system.ld.application.primaryports.mapper.inventorymovements;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.RegisterNewInventoryMovementDTO;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RegisterNewInventoryMovementDTOMapper {

    RegisterNewInventoryMovementDTOMapper INSTANCE = Mappers.getMapper(RegisterNewInventoryMovementDTOMapper.class);

    @Mapping(target = "id", ignore = true)
    InventoryMovementDomain toDomain(RegisterNewInventoryMovementDTO inventoryMovementDTO);

    RegisterNewInventoryMovementDTO toDTO(InventoryMovementDomain inventoryMovementDomain);

    List<RegisterNewInventoryMovementDTO> toDTOCollection(List<InventoryMovementDomain> inventoryMovementDomainList);
}
