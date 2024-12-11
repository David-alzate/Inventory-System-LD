package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserLastNameRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.rules.UserLastNameFormatIsValidRule;
import co.inventory.system.ld.domain.users.rules.UserLastNameIsNotEmpyRule;
import co.inventory.system.ld.domain.users.rules.UserLastNameIsNotNullRule;
import co.inventory.system.ld.domain.users.rules.UserNameLenghIsValidRule;

@Service
public class RegisterNewUserLastNameRulesValidatorImpl implements RegisterNewUserLastNameRulesValidator {

	private final UserLastNameIsNotEmpyRule userLastNameIsNotEmpyRule;
	private final UserLastNameIsNotNullRule userLastNameIsNotNullRule;
	private final UserLastNameFormatIsValidRule userLastNameFormatIsValidRule;
	private final UserNameLenghIsValidRule userNameLenghIsValidRule;

	public RegisterNewUserLastNameRulesValidatorImpl(UserLastNameIsNotEmpyRule userLastNameIsNotEmpyRule,
			UserLastNameIsNotNullRule userLastNameIsNotNullRule,
			UserLastNameFormatIsValidRule userLastNameFormatIsValidRule,
			UserNameLenghIsValidRule userNameLenghIsValidRule) {
		super();
		this.userLastNameIsNotEmpyRule = userLastNameIsNotEmpyRule;
		this.userLastNameIsNotNullRule = userLastNameIsNotNullRule;
		this.userLastNameFormatIsValidRule = userLastNameFormatIsValidRule;
		this.userNameLenghIsValidRule = userNameLenghIsValidRule;
	}

	@Override
	public void validate(UserDomain data) {
		userLastNameIsNotEmpyRule.validate(data.getLastName());
		userLastNameIsNotNullRule.validate(data.getLastName());
		userLastNameFormatIsValidRule.validate(data.getLastName());
		userNameLenghIsValidRule.validate(data.getLastName());
	}

}
