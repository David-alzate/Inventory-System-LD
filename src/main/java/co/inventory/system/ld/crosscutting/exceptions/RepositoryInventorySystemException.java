package co.inventory.system.ld.crosscutting.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class RepositoryInventorySystemException extends InventorySystemException {

	private static final long serialVersionUID = 1L;

	public RepositoryInventorySystemException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.REPOSITORY);
	}

	public static final RepositoryInventorySystemException create(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		return new RepositoryInventorySystemException(userMessage, technicalMessage, rootException);
	}

	public static final RepositoryInventorySystemException create(final String userMessage) {
		return new RepositoryInventorySystemException(userMessage, userMessage, new Exception());
	}

	public static final RepositoryInventorySystemException create(final String userMessage,
			final String technicalMessage) {
		return new RepositoryInventorySystemException(userMessage, technicalMessage, new Exception());
	}

}
