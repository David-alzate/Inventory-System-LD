package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserIdNumberLenghIsNotValidException extends RuleInventorySystemException{
	
	private static final long serialVersionUID = 1L;

    private UserIdNumberLenghIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserIdNumberLenghIsNotValidException create() {
        var userMessage = "El tamaño para el número de identificación del usuario no es valido";
        return new UserIdNumberLenghIsNotValidException(userMessage);
    }

}
