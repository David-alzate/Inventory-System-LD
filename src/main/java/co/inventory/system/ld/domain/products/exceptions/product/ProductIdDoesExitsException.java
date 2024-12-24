package co.inventory.system.ld.domain.products.exceptions.product;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductIdDoesExitsException extends RuleInventorySystemException{
	
	private static final long serialVersionUID = 1L;

    public ProductIdDoesExitsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static ProductIdDoesExitsException create() {
        var userMessage = "El id del producto ya existe";
        return new ProductIdDoesExitsException(userMessage);
    }

}
