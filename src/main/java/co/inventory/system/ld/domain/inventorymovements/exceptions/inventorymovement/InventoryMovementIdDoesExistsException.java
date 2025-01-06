package co.inventory.system.ld.domain.inventorymovements.exceptions.inventorymovement;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class InventoryMovementIdDoesExistsException extends RuleInventorySystemException {

    public InventoryMovementIdDoesExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }
}
