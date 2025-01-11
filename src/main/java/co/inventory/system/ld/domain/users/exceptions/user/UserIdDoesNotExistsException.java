package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserIdDoesNotExistsException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	private UserIdDoesNotExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static UserIdDoesNotExistsException create() {
		var userMessage = "El id del usuario no existe";
		return new UserIdDoesNotExistsException(userMessage);
	}
}
