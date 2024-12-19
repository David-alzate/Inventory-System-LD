package co.inventory.system.ld.domain.suppliers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class SupplierIdDoesNotExistException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public SupplierIdDoesNotExistException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }


    public static final SupplierIdDoesNotExistException create() {
        var userMessage = "El id del proveedor no existe";
        return new SupplierIdDoesNotExistException(userMessage);
    }
}
