package co.inventory.system.ld.application.primaryports.interactor.inventorymovements.inventorymovement;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.InventoryMovementDTO;
import co.inventory.system.ld.application.primaryports.interactor.InteractorWithReturn;

import java.util.List;

public interface GetInventoryMovementInteractor extends InteractorWithReturn<InventoryMovementDTO, List<InventoryMovementDTO>> {
}
