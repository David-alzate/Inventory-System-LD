package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerLastNameIsEmptyException extends RuleInventorySystemException{

	 private static final long serialVersionUID = 1L;

	    private CustomerLastNameIsEmptyException(final String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static CustomerLastNameIsEmptyException create() {
	        var userMessage = "El apellido del cliente no puede ser vacio";
	        return new CustomerLastNameIsEmptyException(userMessage);
	    }

}
