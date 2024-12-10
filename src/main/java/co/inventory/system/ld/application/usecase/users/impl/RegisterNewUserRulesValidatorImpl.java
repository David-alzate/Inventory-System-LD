package co.inventory.system.ld.application.usecase.users.impl;

import co.inventory.system.ld.application.usecase.users.RegisterNewUserIdRulesValidator;
import co.inventory.system.ld.application.usecase.users.RegisterNewUserNameRulesValidator;
import co.inventory.system.ld.application.usecase.users.RegisterNewUserRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewUserRulesValidatorImpl implements RegisterNewUserRulesValidator {

    private final RegisterNewUserIdRulesValidator registerNewUserIdRulesValidator;
    private final RegisterNewUserNameRulesValidator registerNewUserNameRulesValidator;

    public RegisterNewUserRulesValidatorImpl(RegisterNewUserIdRulesValidator registerNewUserIdRulesValidator,
                                             RegisterNewUserNameRulesValidator registerNewUserNameRulesValidator) {
        this.registerNewUserIdRulesValidator = registerNewUserIdRulesValidator;
        this.registerNewUserNameRulesValidator = registerNewUserNameRulesValidator;
    }

    @Override
    public void validate(UserDomain data) {
        registerNewUserNameRulesValidator.validate(data);
        registerNewUserIdRulesValidator.validate(data);

    }
}
