package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.inventorymovements;

import co.inventory.system.ld.application.secondaryports.entity.inventorymovements.InventoryMovementEntity;

import java.util.List;

public interface InventoryMovementsRepositoryCustom {

    List<InventoryMovementEntity> findByFilter (InventoryMovementEntity filter);
}
