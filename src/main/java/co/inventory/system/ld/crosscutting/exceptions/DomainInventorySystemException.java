package co.inventory.system.ld.crosscutting.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class DomainInventorySystemException extends InventorySystemException {

	private static final long serialVersionUID = 1L;

	public DomainInventorySystemException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DOMAIN);
	}

	public static final DomainInventorySystemException create(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		return new DomainInventorySystemException(userMessage, technicalMessage, rootException);
	}

	public static final DomainInventorySystemException create(final String userMessage) {
		return new DomainInventorySystemException(userMessage, userMessage, new Exception());
	}

	public static final DomainInventorySystemException create(final String userMessage,
			final String technicalMessage) {
		return new DomainInventorySystemException(userMessage, technicalMessage, new Exception());
	}

}
