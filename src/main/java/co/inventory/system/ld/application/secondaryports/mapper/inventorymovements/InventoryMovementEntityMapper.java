package co.inventory.system.ld.application.secondaryports.mapper.inventorymovements;

import co.inventory.system.ld.application.secondaryports.entity.inventorymovements.InventoryMovementEntity;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InventoryMovementEntityMapper {
    InventoryMovementEntityMapper INSTANCE = Mappers.getMapper(InventoryMovementEntityMapper.class);

    InventoryMovementEntity toEntity(InventoryMovementDomain inventoryMovementDomain);

    InventoryMovementDomain toDomain(InventoryMovementEntity inventoryMovementEntity);

    List<InventoryMovementEntity> toEntityCollection(List<InventoryMovementDomain> inventoryMovementDomainList);

    List<InventoryMovementDomain> toDomainCollection(List<InventoryMovementEntity> inventoryMovementEntityList);

}
