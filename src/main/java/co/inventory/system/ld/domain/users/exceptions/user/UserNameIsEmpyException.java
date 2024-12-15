package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserNameIsEmpyException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private UserNameIsEmpyException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserNameIsEmpyException create() {
        var userMessage = "El nombre del usuario no puede ser vacio";
        return new UserNameIsEmpyException(userMessage);
    }
}