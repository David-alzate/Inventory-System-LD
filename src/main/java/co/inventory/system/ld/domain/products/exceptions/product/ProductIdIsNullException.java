package co.inventory.system.ld.domain.products.exceptions.product;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class ProductIdIsNullException extends RuleInventorySystemException{
	
	private static final long serialVersionUID = 1L;

    public ProductIdIsNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static ProductIdIsNullException create() {
        var userMessage = "El id del producto es nulo";
        return new ProductIdIsNullException(userMessage);
    }

}
