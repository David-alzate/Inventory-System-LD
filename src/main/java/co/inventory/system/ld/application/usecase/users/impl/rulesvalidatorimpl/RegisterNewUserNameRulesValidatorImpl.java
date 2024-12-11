package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserNameRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.rules.UserNameFormatIsValidRule;
import co.inventory.system.ld.domain.users.rules.UserNameIsNotEmpyRule;
import co.inventory.system.ld.domain.users.rules.UserNameIsNotNullRule;
import co.inventory.system.ld.domain.users.rules.UserNameLenghIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewUserNameRulesValidatorImpl implements RegisterNewUserNameRulesValidator {

	private final UserNameIsNotNullRule userNameIsNotNullRule;
	private final UserNameIsNotEmpyRule userNameIsNotEmpyRule;
	private final UserNameFormatIsValidRule userNameFormatIsValidRule;
	private final UserNameLenghIsValidRule userNameLenghIsValidRule;

	public RegisterNewUserNameRulesValidatorImpl(UserNameIsNotNullRule userNameIsNotNullRule,
			UserNameIsNotEmpyRule userNameIsNotEmpyRule, UserNameFormatIsValidRule userNameFormatIsValidRule,
			UserNameLenghIsValidRule userNameLenghIsValidRule) {
		this.userNameIsNotNullRule = userNameIsNotNullRule;
		this.userNameIsNotEmpyRule = userNameIsNotEmpyRule;
		this.userNameFormatIsValidRule = userNameFormatIsValidRule;
		this.userNameLenghIsValidRule = userNameLenghIsValidRule;
	}

	@Override
	public void validate(UserDomain data) {
		userNameIsNotNullRule.validate(data.getName());
		userNameIsNotEmpyRule.validate(data.getName());
		userNameFormatIsValidRule.validate(data.getName());
		userNameLenghIsValidRule.validate(data.getName());
	}
}
