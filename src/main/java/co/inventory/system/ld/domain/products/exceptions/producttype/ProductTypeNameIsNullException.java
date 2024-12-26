package co.inventory.system.ld.domain.products.exceptions.producttype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductTypeNameIsNullException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductTypeNameIsNullException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductTypeNameIsNullException create() {
		var userMessage = "El id del tipo de producto ya existe";
		return new ProductTypeNameIsNullException(userMessage);
	}

}
