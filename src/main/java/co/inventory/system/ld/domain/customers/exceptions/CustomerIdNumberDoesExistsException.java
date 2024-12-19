package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerIdNumberDoesExistsException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public CustomerIdNumberDoesExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerIdNumberDoesExistsException create() {
        var userMessage = "El id del cliente ya existe.";
        return new CustomerIdNumberDoesExistsException(userMessage);
    }
}
