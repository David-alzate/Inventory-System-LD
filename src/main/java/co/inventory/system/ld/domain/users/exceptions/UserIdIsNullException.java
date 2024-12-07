package co.inventory.system.ld.domain.users.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserIdIsNullException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private UserIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserIdIsNullException create() {
        var userMessage = "El id no puede ser nulo";
        return new UserIdIsNullException(userMessage);
    }
}
