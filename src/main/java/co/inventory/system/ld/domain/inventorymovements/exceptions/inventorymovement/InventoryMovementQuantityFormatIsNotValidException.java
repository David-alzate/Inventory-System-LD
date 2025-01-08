package co.inventory.system.ld.domain.inventorymovements.exceptions.inventorymovement;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class InventoryMovementQuantityFormatIsNotValidException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public InventoryMovementQuantityFormatIsNotValidException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static InventoryMovementQuantityFormatIsNotValidException create(){
        var userMessage = "El formato de la cantidad para el movimiento de inventario no es valido";
        return new InventoryMovementQuantityFormatIsNotValidException(userMessage);
    }
}
