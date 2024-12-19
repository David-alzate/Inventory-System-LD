package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerIdDoesExistsException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private CustomerIdDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerIdDoesExistsException create() {
        var userMessage = "El id del cliente ya existe";
        return new CustomerIdDoesExistsException(userMessage);
    }
}
