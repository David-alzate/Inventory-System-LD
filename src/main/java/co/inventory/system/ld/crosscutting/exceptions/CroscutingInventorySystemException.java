package co.inventory.system.ld.crosscutting.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class CroscutingInventorySystemException extends InventorySystemException {

	private static final long serialVersionUID = 1L;

	public CroscutingInventorySystemException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.CROSSCUTING);
	}

	public static final CroscutingInventorySystemException create(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		return new CroscutingInventorySystemException(userMessage, technicalMessage, rootException);
	}

	public static final CroscutingInventorySystemException create(final String userMessage) {
		return new CroscutingInventorySystemException(userMessage, userMessage, new Exception());
	}

	public static final CroscutingInventorySystemException create(final String userMessage,
			final String technicalMessage) {
		return new CroscutingInventorySystemException(userMessage, technicalMessage, new Exception());
	}

}
