package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserNameIsNullException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private UserNameIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserNameIsNullException create() {
        var userMessage = "El nombre del usuario no puede ser nulo";
        return new UserNameIsNullException(userMessage);
    }
}
