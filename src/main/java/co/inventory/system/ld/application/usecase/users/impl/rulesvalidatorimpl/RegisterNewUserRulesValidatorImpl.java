package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserIdRulesValidator;
import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserLastNameRulesValidator;
import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserNameRulesValidator;
import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewUserRulesValidatorImpl implements RegisterNewUserRulesValidator {

	private final RegisterNewUserIdRulesValidator registerNewUserIdRulesValidator;
	private final RegisterNewUserNameRulesValidator registerNewUserNameRulesValidator;
	private final RegisterNewUserLastNameRulesValidator registerNewUserLastNameRulesValidator;

	public RegisterNewUserRulesValidatorImpl(RegisterNewUserIdRulesValidator registerNewUserIdRulesValidator,
			RegisterNewUserNameRulesValidator registerNewUserNameRulesValidator,
			RegisterNewUserLastNameRulesValidator registerNewUserLastNameRulesValidator) {
		super();
		this.registerNewUserIdRulesValidator = registerNewUserIdRulesValidator;
		this.registerNewUserNameRulesValidator = registerNewUserNameRulesValidator;
		this.registerNewUserLastNameRulesValidator = registerNewUserLastNameRulesValidator;
	}

	@Override
	public void validate(UserDomain data) {
		registerNewUserIdRulesValidator.validate(data);
		registerNewUserNameRulesValidator.validate(data);
		registerNewUserLastNameRulesValidator.validate(data);
	}
}
