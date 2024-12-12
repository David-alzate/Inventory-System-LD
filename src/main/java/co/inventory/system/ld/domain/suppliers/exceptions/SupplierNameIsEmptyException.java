package co.inventory.system.ld.domain.suppliers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class SupplierNameIsEmptyException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public SupplierNameIsEmptyException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final SupplierNameIsEmptyException create() {
        var userMessage = "Supplier name is empty";
        return new SupplierNameIsEmptyException(userMessage);
    }
}
