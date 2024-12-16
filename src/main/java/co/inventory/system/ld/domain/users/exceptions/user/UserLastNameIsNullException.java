package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserLastNameIsNullException extends RuleInventorySystemException{
	
	 private static final long serialVersionUID = 1L;

	    private UserLastNameIsNullException(final String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static UserLastNameIsNullException create() {
	        var userMessage = "El apellido del usuario no puede ser nulo";
	        return new UserLastNameIsNullException(userMessage);
	    }

}
