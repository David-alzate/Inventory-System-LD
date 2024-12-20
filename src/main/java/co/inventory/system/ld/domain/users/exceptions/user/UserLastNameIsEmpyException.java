package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class UserLastNameIsEmpyException extends RuleInventorySystemException{
	
	 private static final long serialVersionUID = 1L;

	    private UserLastNameIsEmpyException(final String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static UserLastNameIsEmpyException create() {
	        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00012);
	        return new UserLastNameIsEmpyException(userMessage);
	    }

}
