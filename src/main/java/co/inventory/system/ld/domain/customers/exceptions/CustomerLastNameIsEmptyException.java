package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class CustomerLastNameIsEmptyException extends RuleInventorySystemException{

	 private static final long serialVersionUID = 1L;

	    private CustomerLastNameIsEmptyException(final String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static CustomerLastNameIsEmptyException create() {
	        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00049);
	        return new CustomerLastNameIsEmptyException(userMessage);
	    }

}
