package co.inventory.system.ld.domain.suppliers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class SupplierNameLengthIsNotValidException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public SupplierNameLengthIsNotValidException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final SupplierNameLengthIsNotValidException create() {
        var userMessage = "Supplier name length is not valid";
        return new SupplierNameLengthIsNotValidException(userMessage);
    }
}
