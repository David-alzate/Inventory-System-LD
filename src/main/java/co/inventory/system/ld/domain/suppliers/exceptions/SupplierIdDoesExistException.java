package co.inventory.system.ld.domain.suppliers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class SupplierIdDoesExistException extends InventorySystemException {
    public SupplierIdDoesExistException(String userMessage, String technicalMessage, Exception rootException, Layer layer) {
        super(userMessage, technicalMessage, rootException, layer);
    }
}
