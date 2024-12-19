package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserEmailForUserTypeDoesExistsException extends RuleInventorySystemException{
	
	 private static final long serialVersionUID = 1L;

	    private UserEmailForUserTypeDoesExistsException(final String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static UserEmailForUserTypeDoesExistsException create() {
	        var userMessage = "El email del usuario ya existe";
	        return new UserEmailForUserTypeDoesExistsException(userMessage);
	    }

}
