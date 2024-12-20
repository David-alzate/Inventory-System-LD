package co.inventory.system.ld.domain.commons.exceptions.idtype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class IdTypeIdIsDefaultValueException extends RuleInventorySystemException {
	
	private static final long serialVersionUID = 1L;

    public IdTypeIdIsDefaultValueException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final IdTypeIdIsDefaultValueException create(){
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00025);
        return new IdTypeIdIsDefaultValueException(userMessage);
    }
}
