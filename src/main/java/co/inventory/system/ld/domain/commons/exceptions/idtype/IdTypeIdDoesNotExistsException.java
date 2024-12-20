package co.inventory.system.ld.domain.commons.exceptions.idtype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class IdTypeIdDoesNotExistsException extends RuleInventorySystemException {
	
	private static final long serialVersionUID = 1L;

    public IdTypeIdDoesNotExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final IdTypeIdDoesNotExistsException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00024);
        return new IdTypeIdDoesNotExistsException(userMessage);
    }
}
