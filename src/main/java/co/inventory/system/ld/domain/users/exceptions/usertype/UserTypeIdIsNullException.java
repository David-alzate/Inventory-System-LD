package co.inventory.system.ld.domain.users.exceptions.usertype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserTypeIdIsNullException extends RuleInventorySystemException{
	
	private static final long serialVersionUID = 1L;

    private UserTypeIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserTypeIdIsNullException create() {
        var userMessage = "El id del tipo de usuario no puede ser nulo.";
        return new UserTypeIdIsNullException(userMessage);
    }

}