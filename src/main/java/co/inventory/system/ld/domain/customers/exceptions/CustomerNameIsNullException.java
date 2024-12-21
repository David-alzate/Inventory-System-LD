package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class CustomerNameIsNullException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private CustomerNameIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerNameIsNullException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00054);
        return new CustomerNameIsNullException(userMessage);
    }
}
