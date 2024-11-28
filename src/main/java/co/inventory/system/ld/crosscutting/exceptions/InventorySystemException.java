package co.inventory.system.ld.crosscutting.exceptions;

import co.inventory.system.ld.crosscutting.exceptions.enums.Layer;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;

public class InventorySystemException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String userMessage;
	private Layer layer;

	public InventorySystemException(final String userMessage, final String technicalMessage,
			final Exception rootException, final Layer layer) {
		super(ObjectHelper.getDefault(technicalMessage, TextHelper.applyTrim(userMessage)),
				ObjectHelper.getDefault(rootException, new Exception()));
		setUserMessage(userMessage);
		setLayer(layer);
	}

	public String getUserMessage() {
		return userMessage;
	}

	private void setUserMessage(final String userMessage) {
		this.userMessage = TextHelper.applyTrim(userMessage);
	}

	public Layer getLayer() {
		return layer;
	}

	private void setLayer(final Layer layer) {
		this.layer = ObjectHelper.getDefault(layer, Layer.GENERAL);
	}

}
