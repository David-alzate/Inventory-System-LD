package co.inventory.system.ld.domain.suppliers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class SupplierIdIsNullException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public SupplierIdIsNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final SupplierIdIsNullException create() {
        var userMessage = "El id del proveedor es nulo";
        return new SupplierIdIsNullException(userMessage);
    }

}
