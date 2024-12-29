package co.inventory.system.ld.domain.users.exceptions.usertype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class UserTypeDoesNotExistException extends RuleInventorySystemException {
	
	private static final long serialVersionUID = 1L;

    private UserTypeDoesNotExistException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserTypeDoesNotExistException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00085);
        return new UserTypeDoesNotExistException(userMessage);
    }

}
