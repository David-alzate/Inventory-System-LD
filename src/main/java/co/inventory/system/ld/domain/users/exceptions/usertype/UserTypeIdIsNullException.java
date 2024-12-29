package co.inventory.system.ld.domain.users.exceptions.usertype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class UserTypeIdIsNullException extends RuleInventorySystemException{
	
	private static final long serialVersionUID = 1L;

    private UserTypeIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserTypeIdIsNullException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00087);
        return new UserTypeIdIsNullException(userMessage);
    }

}
