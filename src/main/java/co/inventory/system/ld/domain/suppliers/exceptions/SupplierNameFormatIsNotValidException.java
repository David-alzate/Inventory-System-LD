package co.inventory.system.ld.domain.suppliers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class SupplierNameFormatIsNotValidException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public SupplierNameFormatIsNotValidException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final SupplierNameFormatIsNotValidException create() {
        var userMessage = "Supplier name format is not valid";
        return new SupplierNameFormatIsNotValidException(userMessage);
    }
}
