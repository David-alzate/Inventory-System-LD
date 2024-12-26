package co.inventory.system.ld.domain.products.exceptions.producttype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductTypeNameLenghIsNotValidException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductTypeNameLenghIsNotValidException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductTypeNameLenghIsNotValidException create() {
		var userMessage = "El tamaño del nombre del tipo de producto no es válido";
		return new ProductTypeNameLenghIsNotValidException(userMessage);
	}

}
