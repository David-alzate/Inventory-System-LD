package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserEmailFormatIsNotValidException extends RuleInventorySystemException{
	
    private static final long serialVersionUID = 1L;

    private UserEmailFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserEmailFormatIsNotValidException create() {
        var userMessage = "El formato del email del usuario no es valido";
        return new UserEmailFormatIsNotValidException(userMessage);
    }

}
