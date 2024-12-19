package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerEmailFormatIsNotValidException extends RuleInventorySystemException{

    private static final long serialVersionUID = 1L;

    private CustomerEmailFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerEmailFormatIsNotValidException create() {
        var userMessage = "El formato del email del cliente no es valido";
        return new CustomerEmailFormatIsNotValidException(userMessage);
    }

}
