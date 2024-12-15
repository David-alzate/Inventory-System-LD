package co.inventory.system.ld.domain.users.exceptions.usertype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserTypeIdIsDefaultValueException extends RuleInventorySystemException{
	
	private static final long serialVersionUID = 1L;

    private UserTypeIdIsDefaultValueException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserTypeIdIsDefaultValueException create() {
        var userMessage = "El id del tipo de usuario no puede ser el valor por defecto";
        return new UserTypeIdIsDefaultValueException(userMessage);
    }

}
