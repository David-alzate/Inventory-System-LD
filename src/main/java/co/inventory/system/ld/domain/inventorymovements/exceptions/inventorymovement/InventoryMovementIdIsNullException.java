package co.inventory.system.ld.domain.inventorymovements.exceptions.inventorymovement;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class InventoryMovementIdIsNullException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public InventoryMovementIdIsNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static InventoryMovementIdDoesExistsException create(){
        var userMessage = "El id del movimiento de inventario no puede ser nulo";
        return new InventoryMovementIdDoesExistsException(userMessage);
    }
}
