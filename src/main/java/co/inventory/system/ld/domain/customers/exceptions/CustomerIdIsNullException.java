package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class CustomerIdIsNullException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private CustomerIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerIdIsNullException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00045);
        return new CustomerIdIsNullException(userMessage);
    }
}
