package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class CustomerLastNameIsNullException extends RuleInventorySystemException{

	 private static final long serialVersionUID = 1L;

	    private CustomerLastNameIsNullException(final String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static CustomerLastNameIsNullException create() {
	        var userMessage = "El apellido del cliente no puede ser nulo";
	        return new CustomerLastNameIsNullException(userMessage);
	    }

}
