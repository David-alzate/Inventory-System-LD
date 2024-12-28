package co.inventory.system.ld.domain.products.exceptions.producttype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductTypeIdIsNullException extends RuleInventorySystemException {
	
	private static final long serialVersionUID = 1L;

	public ProductTypeIdIsNullException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductTypeIdIsNullException create() {
		var userMessage = "El id del tipo del producto no puede ser nulo";
		return new ProductTypeIdIsNullException(userMessage);
	}

}
