package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserIdNumberRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.rules.user.UserIdNumberForUserTypeDoesNotExistsRule;
import co.inventory.system.ld.domain.users.rules.user.UserIdNumberLenghIsValidRule;

@Service
public class RegisterNewUserIdNumberRulesValidatorImpl implements RegisterNewUserIdNumberRulesValidator {

	private final UserIdNumberForUserTypeDoesNotExistsRule userIdNumberForUserTypeDoesNotExistsRule;
	private final UserIdNumberLenghIsValidRule userIdNumberLenghIsValidRule;

	public RegisterNewUserIdNumberRulesValidatorImpl(
			UserIdNumberForUserTypeDoesNotExistsRule userIdNumberForUserTypeDoesNotExistsRule,
			UserIdNumberLenghIsValidRule userIdNumberLenghIsValidRule) {
		this.userIdNumberForUserTypeDoesNotExistsRule = userIdNumberForUserTypeDoesNotExistsRule;
		this.userIdNumberLenghIsValidRule = userIdNumberLenghIsValidRule;
	}

	@Override
	public void validate(UserDomain data) {
		userIdNumberForUserTypeDoesNotExistsRule.validate(data);
		userIdNumberLenghIsValidRule.validate(data);
	}
}
