package co.inventory.system.ld.domain.products.exceptions.product;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductNameIsNullException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductNameIsNullException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductNameIsNullException create() {
		var userMessage = "El id del producto ya existe";
		return new ProductNameIsNullException(userMessage);
	}

}
