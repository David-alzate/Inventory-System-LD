package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class CustomerNameIsEmptyException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    private CustomerNameIsEmptyException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerNameIsEmptyException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00053);
        return new CustomerNameIsEmptyException(userMessage);
    }
}