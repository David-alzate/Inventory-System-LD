package co.inventory.system.ld.domain.users.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserLastNameLenghIsNotValidException extends RuleInventorySystemException{
	
	private static final long serialVersionUID = 1L;

    private UserLastNameLenghIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserLastNameLenghIsNotValidException create() {
        var userMessage = "El tamaño del apellido no es valido";
        return new UserLastNameLenghIsNotValidException(userMessage);
    }

}
