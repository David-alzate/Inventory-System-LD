package co.inventory.system.ld.domain.users.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserIdDoesExistsException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private UserIdDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserIdDoesExistsException create() {
        var userMessage = "El id del usuario ya existe";
        return new UserIdDoesExistsException(userMessage);
    }
}
