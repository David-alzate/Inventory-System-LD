package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class UserIdNumberLenghIsNotValidException extends RuleInventorySystemException{
	
	private static final long serialVersionUID = 1L;

    private UserIdNumberLenghIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserIdNumberLenghIsNotValidException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00010);
        return new UserIdNumberLenghIsNotValidException(userMessage);
    }

}
