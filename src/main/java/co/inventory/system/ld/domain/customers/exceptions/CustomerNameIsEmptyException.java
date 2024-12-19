package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerNameIsEmptyException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private CustomerNameIsEmptyException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerNameIsEmptyException create() {
        var userMessage = "El nombre del cliente no puede ser vacio";
        return new CustomerNameIsEmptyException(userMessage);
    }
}