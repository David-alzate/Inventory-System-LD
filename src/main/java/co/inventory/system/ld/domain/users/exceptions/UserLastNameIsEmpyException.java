package co.inventory.system.ld.domain.users.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserLastNameIsEmpyException extends RuleInventorySystemException{
	
	 private static final long serialVersionUID = 1L;

	    private UserLastNameIsEmpyException(final String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static UserLastNameIsEmpyException create() {
	        var userMessage = "El apellido del usuario no puede ser vacio";
	        return new UserLastNameIsEmpyException(userMessage);
	    }

}
