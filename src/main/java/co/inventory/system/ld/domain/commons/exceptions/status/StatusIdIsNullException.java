package co.inventory.system.ld.domain.commons.exceptions.status;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class StatusIdIsNullException extends RuleInventorySystemException {

    public StatusIdIsNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final StatusIdIsNullException create(){
        var userMessage = "El id del status no puede ser nulo";
        return new StatusIdIsNullException(userMessage);
    }
}
