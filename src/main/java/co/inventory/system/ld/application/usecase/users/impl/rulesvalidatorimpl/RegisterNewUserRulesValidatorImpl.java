package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserEmailRulesValidator;
import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserIdNumberRulesValidator;
import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserIdRulesValidator;
import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserLastNameRulesValidator;
import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserNameRulesValidator;
import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;

@Service
public class RegisterNewUserRulesValidatorImpl implements RegisterNewUserRulesValidator {

	private final RegisterNewUserIdRulesValidator registerNewUserIdRulesValidator;
	private final RegisterNewUserNameRulesValidator registerNewUserNameRulesValidator;
	private final RegisterNewUserLastNameRulesValidator registerNewUserLastNameRulesValidator;
	private final RegisterNewUserEmailRulesValidator registerNewUserEmailRulesValidator;
	private final RegisterNewUserIdNumberRulesValidator registerNewUserIdNumberRulesValidator;

	public RegisterNewUserRulesValidatorImpl(RegisterNewUserIdRulesValidator registerNewUserIdRulesValidator,
			RegisterNewUserNameRulesValidator registerNewUserNameRulesValidator,
			RegisterNewUserLastNameRulesValidator registerNewUserLastNameRulesValidator,
			RegisterNewUserEmailRulesValidator registerNewUserEmailRulesValidator,
			RegisterNewUserIdNumberRulesValidator registerNewUserIdNumberRulesValidator) {
		this.registerNewUserIdRulesValidator = registerNewUserIdRulesValidator;
		this.registerNewUserNameRulesValidator = registerNewUserNameRulesValidator;
		this.registerNewUserLastNameRulesValidator = registerNewUserLastNameRulesValidator;
		this.registerNewUserEmailRulesValidator = registerNewUserEmailRulesValidator;
		this.registerNewUserIdNumberRulesValidator = registerNewUserIdNumberRulesValidator;
	}

	@Override
	public void validate(UserDomain data) {
		registerNewUserIdRulesValidator.validate(data);
		registerNewUserNameRulesValidator.validate(data);
		registerNewUserLastNameRulesValidator.validate(data);
		registerNewUserEmailRulesValidator.validate(data);
		registerNewUserIdNumberRulesValidator.validate(data);
	}
}
