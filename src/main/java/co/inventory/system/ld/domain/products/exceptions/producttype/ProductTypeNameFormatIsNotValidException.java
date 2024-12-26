package co.inventory.system.ld.domain.products.exceptions.producttype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductTypeNameFormatIsNotValidException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductTypeNameFormatIsNotValidException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductTypeNameFormatIsNotValidException create() {
		var userMessage = "El formato del nombre del tipo de producto no es valido";
		return new ProductTypeNameFormatIsNotValidException(userMessage);
	}

}
