package co.inventory.system.ld.domain.commons.exceptions.idtype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class IdTypeIdIsNullException extends RuleInventorySystemException {
	
	private static final long serialVersionUID = 1L;

    public IdTypeIdIsNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final IdTypeIdIsNullException create(){
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00026);
        return new IdTypeIdIsNullException(userMessage);
    }
}
