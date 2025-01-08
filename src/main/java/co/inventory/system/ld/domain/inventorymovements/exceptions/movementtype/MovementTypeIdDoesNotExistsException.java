package co.inventory.system.ld.domain.inventorymovements.exceptions.movementtype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class MovementTypeIdDoesNotExistsException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public MovementTypeIdDoesNotExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static MovementTypeIdDoesNotExistsException create(){
        var userMessage = "El id del tipo de movimiento no existe";
        return new MovementTypeIdDoesNotExistsException(userMessage);
    }
}
