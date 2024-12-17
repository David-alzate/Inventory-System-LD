package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerIdIsNullException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private CustomerIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerIdIsNullException create() {
        var userMessage = "El id no puede ser nulo";
        return new CustomerIdIsNullException(userMessage);
    }
}
