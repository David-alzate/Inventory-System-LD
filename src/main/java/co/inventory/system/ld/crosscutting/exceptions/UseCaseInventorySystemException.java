package co.inventory.system.ld.crosscutting.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class UseCaseInventorySystemException extends InventorySystemException {

	private static final long serialVersionUID = 1L;

	public UseCaseInventorySystemException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.USECASE);
	}

	public static final UseCaseInventorySystemException create(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		return new UseCaseInventorySystemException(userMessage, technicalMessage, rootException);
	}

	public static final UseCaseInventorySystemException create(final String userMessage) {
		return new UseCaseInventorySystemException(userMessage, userMessage, new Exception());
	}

	public static final UseCaseInventorySystemException create(final String userMessage,
			final String technicalMessage) {
		return new UseCaseInventorySystemException(userMessage, technicalMessage, new Exception());
	}

}
