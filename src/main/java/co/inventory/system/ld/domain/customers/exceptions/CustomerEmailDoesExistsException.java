package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerEmailDoesExistsException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public CustomerEmailDoesExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerEmailDoesExistsException create(){
        var userMessage = "El email del cliente ya se encuentra registrado";
        throw new CustomerEmailDoesExistsException(userMessage);
    }
}
