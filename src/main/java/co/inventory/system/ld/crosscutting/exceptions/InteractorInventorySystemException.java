package co.inventory.system.ld.crosscutting.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class InteractorInventorySystemException extends InventorySystemException {

	private static final long serialVersionUID = 1L;

	public InteractorInventorySystemException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.INTERACTOR);
	}

	public static final InteractorInventorySystemException create(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		return new InteractorInventorySystemException(userMessage, technicalMessage, rootException);
	}

	public static final InteractorInventorySystemException create(final String userMessage) {
		return new InteractorInventorySystemException(userMessage, userMessage, new Exception());
	}

	public static final InteractorInventorySystemException create(final String userMessage,
			final String technicalMessage) {
		return new InteractorInventorySystemException(userMessage, technicalMessage, new Exception());
	}

}
