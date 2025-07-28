package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.*;
import org.springframework.stereotype.Service;

import co.inventory.system.ld.domain.users.UserDomain;

@Service
public class RegisterNewUserRulesValidatorImpl implements RegisterNewUserRulesValidator {

	private final RegisterNewUserIdRulesValidator registerNewUserIdRulesValidator;
	private final RegisterNewUserNameRulesValidator registerNewUserNameRulesValidator;
	private final RegisterNewUserLastNameRulesValidator registerNewUserLastNameRulesValidator;
	private final RegisterNewUserEmailRulesValidator registerNewUserEmailRulesValidator;
	private final RegisterNewUserIdNumberRulesValidator registerNewUserIdNumberRulesValidator;
	private final RegisterNewUserUserTypeRulesValidator registerNewUserUserTypeRulesValidator;
	private final RegisterNewUserIdTypeRulesValidator registerNewUserIdTypeRulesValidator;
	private final RegisterNewUserStatusRulesValidator registerNewUserStatusRulesValidator;
	private final RegisterNewUserPasswordRulesValidator registerNewUserPasswordRulesValidator;

	public RegisterNewUserRulesValidatorImpl(RegisterNewUserIdRulesValidator registerNewUserIdRulesValidator,
                                             RegisterNewUserNameRulesValidator registerNewUserNameRulesValidator,
                                             RegisterNewUserLastNameRulesValidator registerNewUserLastNameRulesValidator,
                                             RegisterNewUserEmailRulesValidator registerNewUserEmailRulesValidator,
                                             RegisterNewUserIdNumberRulesValidator registerNewUserIdNumberRulesValidator,
                                             RegisterNewUserUserTypeRulesValidator registerNewUserUserTypeRulesValidator,
                                             RegisterNewUserIdTypeRulesValidator registerNewUserIdTypeRulesValidator,
                                             RegisterNewUserStatusRulesValidator registerNewUserStatusRulesValidator, RegisterNewUserPasswordRulesValidator registerNewUserPasswordRulesValidator) {
		this.registerNewUserIdRulesValidator = registerNewUserIdRulesValidator;
		this.registerNewUserNameRulesValidator = registerNewUserNameRulesValidator;
		this.registerNewUserLastNameRulesValidator = registerNewUserLastNameRulesValidator;
		this.registerNewUserEmailRulesValidator = registerNewUserEmailRulesValidator;
		this.registerNewUserIdNumberRulesValidator = registerNewUserIdNumberRulesValidator;
		this.registerNewUserUserTypeRulesValidator = registerNewUserUserTypeRulesValidator;
		this.registerNewUserIdTypeRulesValidator = registerNewUserIdTypeRulesValidator;
		this.registerNewUserStatusRulesValidator = registerNewUserStatusRulesValidator;
        this.registerNewUserPasswordRulesValidator = registerNewUserPasswordRulesValidator;
    }

	@Override
	public void validate(UserDomain data) {
		registerNewUserIdRulesValidator.validate(data);
		registerNewUserNameRulesValidator.validate(data);
		registerNewUserLastNameRulesValidator.validate(data);
		registerNewUserEmailRulesValidator.validate(data);
		registerNewUserIdNumberRulesValidator.validate(data);
		registerNewUserUserTypeRulesValidator.validate(data);
		registerNewUserIdTypeRulesValidator.validate(data);
		registerNewUserStatusRulesValidator.validate(data);
		registerNewUserPasswordRulesValidator.validate(data);
	}
}
