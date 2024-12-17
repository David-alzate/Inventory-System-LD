package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerNameFormatIsNotValidException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private CustomerNameFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerNameFormatIsNotValidException create() {
        var userMessage = "El formato del nombre del cliente no es valido";
        return new CustomerNameFormatIsNotValidException(userMessage);
    }
}