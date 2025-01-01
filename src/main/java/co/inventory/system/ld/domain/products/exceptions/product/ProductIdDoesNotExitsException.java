package co.inventory.system.ld.domain.products.exceptions.product;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductIdDoesNotExitsException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductIdDoesNotExitsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductIdDoesNotExitsException create() {
		var userMessage = "El producto no existe";
		return new ProductIdDoesNotExitsException(userMessage);
	}

}
