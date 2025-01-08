package co.inventory.system.ld.domain.inventorymovements.exceptions.inventorymovement;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class InventoryMovementQuantityIsZeroException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public InventoryMovementQuantityIsZeroException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static InventoryMovementQuantityIsZeroException create(){
        var userMessage = "La cantidad para el movimiento de inventario no puede ser cero";
        return new InventoryMovementQuantityIsZeroException(userMessage);
    }
}
