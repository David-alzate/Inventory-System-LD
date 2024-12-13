package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserEmailRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.rules.UserEmailFormatIsValidRule;

@Service
public class RegisterNewUserEmailRulesValidatorImpl implements RegisterNewUserEmailRulesValidator {

	private final UserEmailFormatIsValidRule userEmailFormatIsValidRule;

	public RegisterNewUserEmailRulesValidatorImpl(UserEmailFormatIsValidRule userEmailFormatIsValidRule) {
		this.userEmailFormatIsValidRule = userEmailFormatIsValidRule;
	}

	@Override
	public void validate(UserDomain data) {
		userEmailFormatIsValidRule.validate(data.getEmail());

	}

}
