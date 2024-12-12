package co.inventory.system.ld.domain.suppliers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class SupplierIdDoesExistException extends RuleInventorySystemException {
    private static final long serialVersionUID = 1L;

    public SupplierIdDoesExistException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final SupplierIdDoesExistException create() {
        var userMessage = "El id del proveedor ya existe.";
        return new SupplierIdDoesExistException(userMessage);
    }

}
