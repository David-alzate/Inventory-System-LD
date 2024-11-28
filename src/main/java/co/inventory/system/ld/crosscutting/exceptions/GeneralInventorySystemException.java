package co.inventory.system.ld.crosscutting.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class GeneralInventorySystemException extends InventorySystemException {

	private static final long serialVersionUID = 1L;

	public GeneralInventorySystemException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.GENERAL);
	}

	public static final GeneralInventorySystemException create(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		return new GeneralInventorySystemException(userMessage, technicalMessage, rootException);
	}

	public static final GeneralInventorySystemException create(final String userMessage) {
		return new GeneralInventorySystemException(userMessage, userMessage, new Exception());
	}

	public static final GeneralInventorySystemException create(final String userMessage,
			final String technicalMessage) {
		return new GeneralInventorySystemException(userMessage, technicalMessage, new Exception());
	}

}
