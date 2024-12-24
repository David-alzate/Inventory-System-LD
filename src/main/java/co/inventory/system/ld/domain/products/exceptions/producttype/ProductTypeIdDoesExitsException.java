package co.inventory.system.ld.domain.products.exceptions.producttype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductTypeIdDoesExitsException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductTypeIdDoesExitsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductTypeIdDoesExitsException create() {
		var userMessage = "El id del tipo del producto ya existe";
		return new ProductTypeIdDoesExitsException(userMessage);
	}

}
