package co.inventory.system.ld.domain.products.exceptions.producttype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductTypeNameIsEmpyException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public ProductTypeNameIsEmpyException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProductTypeNameIsEmpyException create() {
		var userMessage = "El nombre del tipo de producto no puede estar vacio";
		return new ProductTypeNameIsEmpyException(userMessage);
	}

}
