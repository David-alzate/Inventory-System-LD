package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserIdNumberForUserTypeDoesExistsException extends RuleInventorySystemException{
	
    private static final long serialVersionUID = 1L;

    private UserIdNumberForUserTypeDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserIdNumberForUserTypeDoesExistsException create() {
        var userMessage = "Ya Existe un usuario con este numero de documento para este tipo de usuario";
        return new UserIdNumberForUserTypeDoesExistsException(userMessage);
    }

}
