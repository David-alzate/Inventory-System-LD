package co.inventory.system.ld.application.usecase.inventorymovements.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.RegisterNewInventoryMovementUsersRulesValidator;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;

@Service
public class RegisterNewInventoryMovementUsersRulesValidatorImpl implements RegisterNewInventoryMovementUsersRulesValidator {

	@Override
	public void validate(InventoryMovementDomain data) {
		// Falta la rule de users
	}
}
