package co.inventory.system.ld.domain.users.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserLastNameFormatIsNotValidException extends RuleInventorySystemException{
	
    private static final long serialVersionUID = 1L;

    private UserLastNameFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserLastNameFormatIsNotValidException create() {
        var userMessage = "El formato del apellido del usuario no es valido";
        return new UserLastNameFormatIsNotValidException(userMessage);
    }

}
