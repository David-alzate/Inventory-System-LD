package co.inventory.system.ld.domain.products.exceptions.product;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductNameIsEmpyException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductNameIsEmpyException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductNameIsEmpyException create() {
		var userMessage = "El nombre del producto no puede estar vacio";
		return new ProductNameIsEmpyException(userMessage);
	}

}
