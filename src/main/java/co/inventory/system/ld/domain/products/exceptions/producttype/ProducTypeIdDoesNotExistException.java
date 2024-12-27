package co.inventory.system.ld.domain.products.exceptions.producttype;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProducTypeIdDoesNotExistException extends RuleInventorySystemException{
	
	private static final long serialVersionUID = 1L;

	public ProducTypeIdDoesNotExistException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static ProducTypeIdDoesNotExistException create() {
		var userMessage = "El id del tipo de producto no existe";
		return new ProducTypeIdDoesNotExistException(userMessage);
	}

}
