package co.inventory.system.ld.application.usecase.inventorymovements.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.RegisterNewInventoryMovementUsersRulesValidator;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import co.inventory.system.ld.domain.users.rules.user.UserIdDoesExitsRule;

@Service
public class RegisterNewInventoryMovementUsersRulesValidatorImpl
		implements RegisterNewInventoryMovementUsersRulesValidator {

	private final UserIdDoesExitsRule userIdDoesExitsRule;

	public RegisterNewInventoryMovementUsersRulesValidatorImpl(UserIdDoesExitsRule userIdDoesExitsRule) {
		this.userIdDoesExitsRule = userIdDoesExitsRule;
	}

	@Override
	public void validate(InventoryMovementDomain data) {
		userIdDoesExitsRule.validate(data.getUser().getId());
	}
}
