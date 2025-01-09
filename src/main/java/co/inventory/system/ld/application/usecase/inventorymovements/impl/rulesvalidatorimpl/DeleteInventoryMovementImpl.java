package co.inventory.system.ld.application.usecase.inventorymovements.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.secondaryports.repository.inventorymovements.InventoryMovementsRepository;
import co.inventory.system.ld.application.usecase.inventorymovements.inventorymovement.DeleteInventoryMovement;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteInventoryMovementImpl implements DeleteInventoryMovement {

    private InventoryMovementsRepository inventoryMovementsRepository;

    public DeleteInventoryMovementImpl(InventoryMovementsRepository inventoryMovementsRepository) {
        this.inventoryMovementsRepository = inventoryMovementsRepository;
    }

    @Override
    public void execute(UUID domain) {
        inventoryMovementsRepository.deleteById(domain);
    }
}
