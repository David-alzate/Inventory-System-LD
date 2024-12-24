package co.inventory.system.ld.domain.products.exceptions.product;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductNameFormatIsNotValidException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductNameFormatIsNotValidException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductNameFormatIsNotValidException create() {
		var userMessage = "El formato del nombre del producto no es valido";
		return new ProductNameFormatIsNotValidException(userMessage);
	}

}
