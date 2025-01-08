package co.inventory.system.ld.domain.inventorymovements.exceptions.movementtype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class MovementTypeIdIsNullException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public MovementTypeIdIsNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static MovementTypeIdIsNullException create( ){
        var userMessage = "El tipo de movimiento no puede ser nulo";
        return new MovementTypeIdIsNullException(userMessage);
    }
}
