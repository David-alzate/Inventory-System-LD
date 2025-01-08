package co.inventory.system.ld.application.usecase.inventorymovements.inventorymovement;

import co.inventory.system.ld.application.usecase.UseCaseWithReturn;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;

import java.util.List;

public interface GetInventoryMovement extends UseCaseWithReturn<InventoryMovementDomain, List<InventoryMovementDomain>> {
}
