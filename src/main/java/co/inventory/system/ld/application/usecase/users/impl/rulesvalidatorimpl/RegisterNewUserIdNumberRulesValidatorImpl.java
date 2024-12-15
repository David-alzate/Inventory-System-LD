package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserIdNumberRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.rules.user.UserIdNumberForUserTypeDoesNotExistsRule;

@Service
public class RegisterNewUserIdNumberRulesValidatorImpl implements RegisterNewUserIdNumberRulesValidator {

	private final UserIdNumberForUserTypeDoesNotExistsRule userIdNumberForUserTypeDoesNotExistsRule;

	public RegisterNewUserIdNumberRulesValidatorImpl(
			UserIdNumberForUserTypeDoesNotExistsRule userIdNumberForUserTypeDoesNotExistsRule) {
		this.userIdNumberForUserTypeDoesNotExistsRule = userIdNumberForUserTypeDoesNotExistsRule;
	}

	@Override
	public void validate(UserDomain data) {
		userIdNumberForUserTypeDoesNotExistsRule.validate(data);
	}

}
