package co.inventory.system.ld.domain.suppliers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class SupplierNameLengthIsNotValidException extends InventorySystemException {

    private static final long serialVersionUID = 1L;

    public SupplierNameLengthIsNotValidException(String userMessage, String technicalMessage, Exception rootException, Layer layer) {
        super(userMessage, technicalMessage, rootException, layer);
    }
}
