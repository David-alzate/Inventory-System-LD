package co.inventory.system.ld.domain.products.exceptions.producttype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class ProductTypeIdIsDefaultValueException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductTypeIdIsDefaultValueException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductTypeIdIsDefaultValueException create() {
		var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00066);
		return new ProductTypeIdIsDefaultValueException(userMessage);
	}

}
