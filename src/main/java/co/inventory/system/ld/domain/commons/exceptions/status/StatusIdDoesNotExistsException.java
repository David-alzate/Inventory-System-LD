package co.inventory.system.ld.domain.commons.exceptions.status;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class StatusIdDoesNotExistsException extends RuleInventorySystemException {
	
	private static final long serialVersionUID = 1L;

    public StatusIdDoesNotExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final StatusIdDoesNotExistsException create() {
        var userMessage = "El id del status no existe.";
        return new StatusIdDoesNotExistsException(userMessage);
    }
}
