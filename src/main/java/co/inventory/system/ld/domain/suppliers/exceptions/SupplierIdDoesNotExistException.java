package co.inventory.system.ld.domain.suppliers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class SupplierIdDoesNotExistException extends RuleInventorySystemException {
    public SupplierIdDoesNotExistException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final SupplierIdDoesNotExistException create() {
        var userMessage = "Supplier Id does not exist";
        return new SupplierIdDoesNotExistException(userMessage);
    }

}
