package co.inventory.system.ld.crosscutting.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;

public class RuleInventorySystemException extends InventorySystemException {

	private static final long serialVersionUID = 1L;

	public RuleInventorySystemException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.RULE);
	}

	public static final RuleInventorySystemException create(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		return new RuleInventorySystemException(userMessage, technicalMessage, rootException);
	}

	public static final RuleInventorySystemException create(final String userMessage) {
		return new RuleInventorySystemException(userMessage, userMessage, new Exception());
	}

	public static final RuleInventorySystemException create(final String userMessage,
			final String technicalMessage) {
		return new RuleInventorySystemException(userMessage, technicalMessage, new Exception());
	}

}
