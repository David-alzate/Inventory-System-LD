package co.inventory.system.ld.domain.customers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class CustomerEmailDoesExistsException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public CustomerEmailDoesExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CustomerEmailDoesExistsException create(){
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00042);
        throw new CustomerEmailDoesExistsException(userMessage);
    }
}
