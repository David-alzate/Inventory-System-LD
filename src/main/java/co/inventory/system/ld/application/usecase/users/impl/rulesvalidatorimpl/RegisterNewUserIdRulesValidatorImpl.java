package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserIdRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.exceptions.user.UserIdDoesExistsException;
import co.inventory.system.ld.domain.users.rules.user.UserIdDoesNotExistsRule;

@Service
public class RegisterNewUserIdRulesValidatorImpl implements RegisterNewUserIdRulesValidator {

	private final UserIdDoesNotExistsRule userIdDoesNotExistsRule;

	public RegisterNewUserIdRulesValidatorImpl(UserIdDoesNotExistsRule userIdDoesNotExistsRule) {
		this.userIdDoesNotExistsRule = userIdDoesNotExistsRule;
	}

	@Override
	public void validate(UserDomain data) {
		data.generateId();
		try {
			userIdDoesNotExistsRule.validate(data.getId());
		} catch (final UserIdDoesExistsException exception) {
			validate(data);
		}
	}
}
