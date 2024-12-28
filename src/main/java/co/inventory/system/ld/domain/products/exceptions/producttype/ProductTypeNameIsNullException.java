package co.inventory.system.ld.domain.products.exceptions.producttype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class ProductTypeNameIsNullException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductTypeNameIsNullException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductTypeNameIsNullException create() {
		var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00064);
		return new ProductTypeNameIsNullException(userMessage);
	}

}
