package co.inventory.system.ld.domain.inventorymovements.exceptions.inventorymovement;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class InventoryMovementIdDoesNotExistsException extends RuleInventorySystemException {

    public InventoryMovementIdDoesNotExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static InventoryMovementIdDoesNotExistsException create(){
        var userMessage = "El id de movimiento de inventario no existe en el sistema";
        return new InventoryMovementIdDoesNotExistsException(userMessage);
    }
}
