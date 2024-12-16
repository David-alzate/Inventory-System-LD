package co.inventory.system.ld.domain.suppliers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class SupplierNameIsNullException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public SupplierNameIsNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final SupplierNameIsNullException create() {
        var userMessage = "Supplier name is null";
        return new SupplierNameIsNullException(userMessage);
    }
}