package co.inventory.system.ld.crosscutting.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class EntitiyInventorySystemException extends InventorySystemException {

	private static final long serialVersionUID = 1L;

	public EntitiyInventorySystemException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.ENTITY);
	}

	public static final EntitiyInventorySystemException create(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		return new EntitiyInventorySystemException(userMessage, technicalMessage, rootException);
	}

	public static final EntitiyInventorySystemException create(final String userMessage) {
		return new EntitiyInventorySystemException(userMessage, userMessage, new Exception());
	}

	public static final EntitiyInventorySystemException create(final String userMessage,
			final String technicalMessage) {
		return new EntitiyInventorySystemException(userMessage, technicalMessage, new Exception());
	}

}
