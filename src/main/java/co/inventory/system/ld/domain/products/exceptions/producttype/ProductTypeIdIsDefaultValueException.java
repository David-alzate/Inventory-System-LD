package co.inventory.system.ld.domain.products.exceptions.producttype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductTypeIdIsDefaultValueException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductTypeIdIsDefaultValueException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductTypeIdIsDefaultValueException create() {
		var userMessage = "El id del tipo del producto no puede ser el valor por defecto";
		return new ProductTypeIdIsDefaultValueException(userMessage);
	}

}
