package co.inventory.system.ld.domain.users.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserNameLenghIsNotValidException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private UserNameLenghIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserNameLenghIsNotValidException create() {
        var userMessage = "El tamaño del nombre no es valido";
        return new UserNameLenghIsNotValidException(userMessage);
    }
}
