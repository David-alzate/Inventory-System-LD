package co.inventory.system.ld.application.primaryports.mapper.inventorymovements;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.InventoryMovementDTO;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InventoryMovementDTOMapper {

    InventoryMovementDTOMapper INSTANCE = Mappers.getMapper(InventoryMovementDTOMapper.class);

    InventoryMovementDomain toDomain(InventoryMovementDTO inventoryMovementDTO);

    InventoryMovementDTO toDTO(InventoryMovementDomain inventoryMovementDomain);

    List<InventoryMovementDTO> toDTOCollection(List<InventoryMovementDomain> inventoryMovementDomainList);
}
