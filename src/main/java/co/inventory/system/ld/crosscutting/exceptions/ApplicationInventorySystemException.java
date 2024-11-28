package co.inventory.system.ld.crosscutting.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class ApplicationInventorySystemException extends InventorySystemException {

	private static final long serialVersionUID = 1L;

	public ApplicationInventorySystemException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.APPLICATION);
	}

	public static final ApplicationInventorySystemException create(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		return new ApplicationInventorySystemException(userMessage, technicalMessage, rootException);
	}

	public static final ApplicationInventorySystemException create(final String userMessage) {
		return new ApplicationInventorySystemException(userMessage, userMessage, new Exception());
	}

	public static final ApplicationInventorySystemException create(final String userMessage,
			final String technicalMessage) {
		return new ApplicationInventorySystemException(userMessage, technicalMessage, new Exception());
	}

}
