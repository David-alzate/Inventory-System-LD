package co.inventory.system.ld.domain.products.exceptions.producttype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class ProductTypeIdDoesExitsException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductTypeIdDoesExitsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductTypeIdDoesExitsException create() {
		var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00061);
		return new ProductTypeIdDoesExitsException(userMessage);
	}

}
