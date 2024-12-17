package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerNameLenghtIsNotValidException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private CustomerNameLenghtIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerNameLenghtIsNotValidException create() {
        var userMessage = "El tamaño del nombre no es valido";
        return new CustomerNameLenghtIsNotValidException(userMessage);
    }
}
