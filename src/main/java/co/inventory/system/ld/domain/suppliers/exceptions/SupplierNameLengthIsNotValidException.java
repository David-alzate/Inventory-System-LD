package co.inventory.system.ld.domain.suppliers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class SupplierNameLengthIsNotValidException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public SupplierNameLengthIsNotValidException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final SupplierNameLengthIsNotValidException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00036);
        return new SupplierNameLengthIsNotValidException(userMessage);
    }
}
