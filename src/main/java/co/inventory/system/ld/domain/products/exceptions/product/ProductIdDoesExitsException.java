package co.inventory.system.ld.domain.products.exceptions.product;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class ProductIdDoesExitsException extends RuleInventorySystemException{
	
	private static final long serialVersionUID = 1L;

    public ProductIdDoesExitsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static ProductIdDoesExitsException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00074);
        return new ProductIdDoesExitsException(userMessage);
    }

}
