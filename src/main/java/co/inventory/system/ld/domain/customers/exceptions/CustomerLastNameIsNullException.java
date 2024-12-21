package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class CustomerLastNameIsNullException extends RuleInventorySystemException{

	 private static final long serialVersionUID = 1L;

	    private CustomerLastNameIsNullException(final String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static CustomerLastNameIsNullException create() {
	        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00050);
	        return new CustomerLastNameIsNullException(userMessage);
	    }

}
