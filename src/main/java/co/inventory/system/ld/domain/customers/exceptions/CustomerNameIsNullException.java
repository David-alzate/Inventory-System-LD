package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerNameIsNullException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private CustomerNameIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerNameIsNullException create() {
        var userMessage = "El nombre del cliente no puede ser nulo";
        return new CustomerNameIsNullException(userMessage);
    }
}
