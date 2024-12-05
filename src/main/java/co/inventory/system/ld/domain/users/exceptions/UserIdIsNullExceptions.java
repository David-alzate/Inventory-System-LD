package co.inventory.system.ld.domain.users.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserIdIsNullExceptions extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private UserIdIsNullExceptions(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserIdIsNullExceptions create() {
        var userMessage = "El id no puede ser nulo";
        return new UserIdIsNullExceptions(userMessage);
    }
}
