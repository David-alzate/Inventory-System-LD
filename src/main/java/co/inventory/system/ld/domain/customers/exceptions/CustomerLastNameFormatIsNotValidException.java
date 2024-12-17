package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerLastNameFormatIsNotValidException extends RuleInventorySystemException{

    private static final long serialVersionUID = 1L;

    private CustomerLastNameFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerLastNameFormatIsNotValidException create() {
        var userMessage = "El formato del apellido del cliente no es valido";
        return new CustomerLastNameFormatIsNotValidException(userMessage);
    }

}
