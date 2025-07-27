package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserPasswordRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.rules.user.*;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewUserPasswordRulesValidatorImpl implements RegisterNewUserPasswordRulesValidator {

    private final UserPasswordHasUppercaseRule userPasswordHasUppercaseRule;
    private final UserPasswordLenghtIsValidRule userPasswordLenghtIsValidRule;
    private final UserPasswordHasANumberRule userPasswordHasANumberRule;
    private final UserPasswordHasSpecialCharacterRule userPasswordHasSpecialCharacterRule;
    private final UserPasswordIsNotEmptyRule userPasswordIsNotEmptyRule;
    private final UserPasswordIsNotNullRule userPasswordIsNotNullRule;

    public RegisterNewUserPasswordRulesValidatorImpl(UserPasswordHasUppercaseRule userPasswordHasUppercaseRule, UserPasswordLenghtIsValidRule userPasswordLenghtIsValidRule, UserPasswordHasANumberRule userPasswordHasANumberRule, UserPasswordHasSpecialCharacterRule userPasswordHasSpecialCharacterRule, UserPasswordIsNotEmptyRule userPasswordIsNotEmptyRule, UserPasswordIsNotNullRule userPasswordIsNotNullRule) {
        this.userPasswordHasUppercaseRule = userPasswordHasUppercaseRule;
        this.userPasswordLenghtIsValidRule = userPasswordLenghtIsValidRule;
        this.userPasswordHasANumberRule = userPasswordHasANumberRule;
        this.userPasswordHasSpecialCharacterRule = userPasswordHasSpecialCharacterRule;
        this.userPasswordIsNotEmptyRule = userPasswordIsNotEmptyRule;
        this.userPasswordIsNotNullRule = userPasswordIsNotNullRule;
    }

    @Override
    public void validate(UserDomain data) {
        userPasswordHasUppercaseRule.validate(data.getPassword());
        userPasswordHasSpecialCharacterRule.validate(data.getPassword());
        userPasswordLenghtIsValidRule.validate(data.getPassword());
        userPasswordHasANumberRule.validate(data.getPassword());
        userPasswordIsNotNullRule.validate(data.getPassword());
        userPasswordIsNotEmptyRule.validate(data.getPassword());
    }
}
