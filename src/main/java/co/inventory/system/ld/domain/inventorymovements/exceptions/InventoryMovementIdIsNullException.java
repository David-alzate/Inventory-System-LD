package co.inventory.system.ld.domain.inventorymovements.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class InventoryMovementIdIsNullException extends RuleInventorySystemException {
    public InventoryMovementIdIsNullException(String userMessage, String technicalMessage, Exception rootException) {
        super(userMessage, technicalMessage, rootException);
    }
}
