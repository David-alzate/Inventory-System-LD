package co.inventory.system.ld.domain.products.exceptions.product;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductNameLenghIsNotValidException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductNameLenghIsNotValidException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductNameLenghIsNotValidException create() {
		var userMessage = "El tamaño del nombre del producto no es válido";
		return new ProductNameLenghIsNotValidException(userMessage);
	}

}
