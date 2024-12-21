package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class CustomerIdNumberDoesExistsException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public CustomerIdNumberDoesExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerIdNumberDoesExistsException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00046);
        return new CustomerIdNumberDoesExistsException(userMessage);
    }
}
