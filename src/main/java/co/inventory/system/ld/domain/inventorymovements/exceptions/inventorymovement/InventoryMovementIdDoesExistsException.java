package co.inventory.system.ld.domain.inventorymovements.exceptions.inventorymovement;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class InventoryMovementIdDoesExistsException extends RuleInventorySystemException {

	private static final long serialVersionUID = 1L;

	public InventoryMovementIdDoesExistsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static InventoryMovementIdDoesExistsException create() {
		var userMessage = "El id de movimiento de inventario ya existe en el sistema";
		return new InventoryMovementIdDoesExistsException(userMessage);
	}
}
