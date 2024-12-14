package co.inventory.system.ld.domain.commons.exceptions.status;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class StatusIdIsDefaultValueException extends RuleInventorySystemException {

    public StatusIdIsDefaultValueException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final StatusIdIsDefaultValueException create(){
        var userMessage = "El id del status no puede ser el valor por defecto";
        return new StatusIdIsDefaultValueException(userMessage);
    }
}
