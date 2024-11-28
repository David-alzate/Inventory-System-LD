package co.inventory.system.ld.crosscutting.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class DTOInventorySystemException extends InventorySystemException {

	private static final long serialVersionUID = 1L;

	public DTOInventorySystemException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DTO);
	}

	public static final DTOInventorySystemException create(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		return new DTOInventorySystemException(userMessage, technicalMessage, rootException);
	}

	public static final DTOInventorySystemException create(final String userMessage) {
		return new DTOInventorySystemException(userMessage, userMessage, new Exception());
	}

	public static final DTOInventorySystemException create(final String userMessage,
			final String technicalMessage) {
		return new DTOInventorySystemException(userMessage, technicalMessage, new Exception());
	}

}
