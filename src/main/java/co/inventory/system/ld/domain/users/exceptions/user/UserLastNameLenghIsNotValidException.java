package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class UserLastNameLenghIsNotValidException extends RuleInventorySystemException{
	
	private static final long serialVersionUID = 1L;

    private UserLastNameLenghIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserLastNameLenghIsNotValidException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00014);
        return new UserLastNameLenghIsNotValidException(userMessage);
    }

}
