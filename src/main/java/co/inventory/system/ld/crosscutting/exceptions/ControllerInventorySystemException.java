package co.inventory.system.ld.crosscutting.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class ControllerInventorySystemException extends InventorySystemException {

	private static final long serialVersionUID = 1L;

	public ControllerInventorySystemException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.CONTROLLER);
	}

	public static final ControllerInventorySystemException create(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		return new ControllerInventorySystemException(userMessage, technicalMessage, rootException);
	}

	public static final ControllerInventorySystemException create(final String userMessage) {
		return new ControllerInventorySystemException(userMessage, userMessage, new Exception());
	}

	public static final ControllerInventorySystemException create(final String userMessage,
			final String technicalMessage) {
		return new ControllerInventorySystemException(userMessage, technicalMessage, new Exception());
	}

}
