package co.inventory.system.ld.domain.commons.exceptions.idtype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class IdTypeIdDoesNotExistsException extends RuleInventorySystemException {
	
	private static final long serialVersionUID = 1L;

    public IdTypeIdDoesNotExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final IdTypeIdDoesNotExistsException create() {
        var userMessage = "El id del tipo de identificacion no existe.";
        return new IdTypeIdDoesNotExistsException(userMessage);
    }
}
