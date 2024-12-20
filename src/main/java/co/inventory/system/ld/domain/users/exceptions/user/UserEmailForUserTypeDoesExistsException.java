package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class UserEmailForUserTypeDoesExistsException extends RuleInventorySystemException{
	
	 private static final long serialVersionUID = 1L;

	    private UserEmailForUserTypeDoesExistsException(final String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static UserEmailForUserTypeDoesExistsException create() {
	        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00006);
	        return new UserEmailForUserTypeDoesExistsException(userMessage);
	    }

}
