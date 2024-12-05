package co.inventory.system.ld.domain.users.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserNameFormatIsNotValidException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private UserNameFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserNameFormatIsNotValidException create() {
        var userMessage = "El formato del nombre del usuario no es valido";
        return new UserNameFormatIsNotValidException(userMessage);
    }
}