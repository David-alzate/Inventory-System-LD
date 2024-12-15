package co.inventory.system.ld.domain.users.exceptions.usertype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserTypeDoesNotExistException extends RuleInventorySystemException {
	
	private static final long serialVersionUID = 1L;

    private UserTypeDoesNotExistException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserTypeDoesNotExistException create() {
        var userMessage = "El tipo de usuario no existe.";
        return new UserTypeDoesNotExistException(userMessage);
    }

}
