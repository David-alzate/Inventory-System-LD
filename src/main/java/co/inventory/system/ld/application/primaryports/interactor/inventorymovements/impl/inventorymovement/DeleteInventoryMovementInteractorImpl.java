package co.inventory.system.ld.application.primaryports.interactor.inventorymovements.impl.inventorymovement;

import co.inventory.system.ld.application.primaryports.interactor.inventorymovements.inventorymovement.DeleteInventoryMovementInteractor;
import co.inventory.system.ld.application.usecase.inventorymovements.inventorymovement.DeleteInventoryMovement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class DeleteInventoryMovementInteractorImpl implements DeleteInventoryMovementInteractor {

    private DeleteInventoryMovement deleteInventoryMovement;

    public DeleteInventoryMovementInteractorImpl(DeleteInventoryMovement deleteInventoryMovement) {
        this.deleteInventoryMovement = deleteInventoryMovement;
    }

    @Override
    public void execute(UUID data) {
        deleteInventoryMovement.execute(data);
    }
}
