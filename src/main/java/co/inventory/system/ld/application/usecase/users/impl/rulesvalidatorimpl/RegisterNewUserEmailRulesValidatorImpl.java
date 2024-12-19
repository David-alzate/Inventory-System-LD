package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserEmailRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.rules.user.UserEmailForUserTypeDoesNotExistsRule;
import co.inventory.system.ld.domain.users.rules.user.UserEmailFormatIsValidRule;

@Service
public class RegisterNewUserEmailRulesValidatorImpl implements RegisterNewUserEmailRulesValidator {

	private final UserEmailFormatIsValidRule userEmailFormatIsValidRule;
	private final UserEmailForUserTypeDoesNotExistsRule userEmailForUserTypeDoesNotExistsRule;

	public RegisterNewUserEmailRulesValidatorImpl(UserEmailFormatIsValidRule userEmailFormatIsValidRule,
            UserEmailForUserTypeDoesNotExistsRule userEmailForUserTypeDoesNotExistsRule) {
        this.userEmailFormatIsValidRule = userEmailFormatIsValidRule;
        this.userEmailForUserTypeDoesNotExistsRule = userEmailForUserTypeDoesNotExistsRule;
        
	}

	@Override
	public void validate(UserDomain data) {
		userEmailFormatIsValidRule.validate(data.getEmail());
		userEmailForUserTypeDoesNotExistsRule.validate(data);

	}

}
