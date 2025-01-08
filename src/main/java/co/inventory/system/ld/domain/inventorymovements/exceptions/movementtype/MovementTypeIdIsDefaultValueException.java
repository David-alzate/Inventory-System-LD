package co.inventory.system.ld.domain.inventorymovements.exceptions.movementtype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class MovementTypeIdIsDefaultValueException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public MovementTypeIdIsDefaultValueException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static MovementTypeIdIsDefaultValueException create(){
        var userMessage = "El tipo de movimiento no puede ser el valor por defecto";
        return new MovementTypeIdIsDefaultValueException(userMessage);
    }
}
