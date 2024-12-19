package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerLastNameLenghIsNotValidException extends RuleInventorySystemException{

	private static final long serialVersionUID = 1L;

    private CustomerLastNameLenghIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerLastNameLenghIsNotValidException create() {
        var userMessage = "El tamaño del apellido no es valido";
        return new CustomerLastNameLenghIsNotValidException(userMessage);
    }

}
