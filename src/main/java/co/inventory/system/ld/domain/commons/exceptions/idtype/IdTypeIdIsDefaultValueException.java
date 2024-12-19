package co.inventory.system.ld.domain.commons.exceptions.idtype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class IdTypeIdIsDefaultValueException extends RuleInventorySystemException {
	
	private static final long serialVersionUID = 1L;

    public IdTypeIdIsDefaultValueException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final IdTypeIdIsDefaultValueException create(){
        var userMessage = "El id del tipo de identificacion no puede ser el valor por defecto";
        return new IdTypeIdIsDefaultValueException(userMessage);
    }
}
