package co.inventory.system.ld.domain.commons.exceptions.status;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class StatusIdDoesNotExistsException extends RuleInventorySystemException {
	
	private static final long serialVersionUID = 1L;

    public StatusIdDoesNotExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final StatusIdDoesNotExistsException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00027);
        return new StatusIdDoesNotExistsException(userMessage);
    }
}
