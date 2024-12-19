package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerIdNumberLenghIsNotValidException extends RuleInventorySystemException{

	private static final long serialVersionUID = 1L;

    private CustomerIdNumberLenghIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerIdNumberLenghIsNotValidException create() {
        var userMessage = "El tamaño para el número de identificación del cliente no es valido";
        return new CustomerIdNumberLenghIsNotValidException(userMessage);
    }

}
