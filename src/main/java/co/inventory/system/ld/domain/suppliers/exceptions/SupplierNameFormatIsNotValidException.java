package co.inventory.system.ld.domain.suppliers.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class SupplierNameFormatIsNotValidException extends RuleInventorySystemException {

    private static final long serialVersionUID = 1L;

    public SupplierNameFormatIsNotValidException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final SupplierNameFormatIsNotValidException create() {
        var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00033);
        return new SupplierNameFormatIsNotValidException(userMessage);
    }
}
