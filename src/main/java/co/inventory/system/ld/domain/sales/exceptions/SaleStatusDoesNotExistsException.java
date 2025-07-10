package co.inventory.system.ld.domain.sales.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class SaleStatusDoesNotExistsException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public SaleStatusDoesNotExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static SaleStatusDoesNotExistsException create() {
        var userMessage = "El estado de venta no existe en el sistema";
        return new SaleStatusDoesNotExistsException(userMessage);
    }
}
