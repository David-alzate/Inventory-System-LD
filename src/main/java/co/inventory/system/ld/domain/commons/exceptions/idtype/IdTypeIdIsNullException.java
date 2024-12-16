package co.inventory.system.ld.domain.commons.exceptions.idtype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class IdTypeIdIsNullException extends RuleInventorySystemException {

    public IdTypeIdIsNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final IdTypeIdIsNullException create(){
        var userMessage = "El id del idType no puede ser nulo";
        return new IdTypeIdIsNullException(userMessage);
    }
}
