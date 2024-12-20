package co.inventory.system.ld.domain.commons.exceptions.status;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class StatusIdIsNullException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public StatusIdIsNullException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static final StatusIdIsNullException create() {
		var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00029);
		return new StatusIdIsNullException(userMessage);
	}
}
