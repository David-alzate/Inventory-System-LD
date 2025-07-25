package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserPasswordRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.rules.user.UserPasswordHasANumberRule;
import co.inventory.system.ld.domain.users.rules.user.UserPasswordHasSpecialCharacterRule;
import co.inventory.system.ld.domain.users.rules.user.UserPasswordHasUppercaseRule;
import co.inventory.system.ld.domain.users.rules.user.UserPasswordLenghtIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewUserPasswordRulesValidatorImpl implements RegisterNewUserPasswordRulesValidator {

    private final UserPasswordHasUppercaseRule userPasswordHasUppercaseRule;
    private final UserPasswordLenghtIsValidRule userPasswordLenghtIsValidRule;
    private final UserPasswordHasANumberRule userPasswordHasANumberRule;
    private final UserPasswordHasSpecialCharacterRule userPasswordHasSpecialCharacterRule;

    public RegisterNewUserPasswordRulesValidatorImpl(UserPasswordHasUppercaseRule userPasswordHasUppercaseRule, UserPasswordLenghtIsValidRule userPasswordLenghtIsValidRule, UserPasswordHasANumberRule userPasswordHasANumberRule, UserPasswordHasSpecialCharacterRule userPasswordHasSpecialCharacterRule) {
        this.userPasswordHasUppercaseRule = userPasswordHasUppercaseRule;
        this.userPasswordLenghtIsValidRule = userPasswordLenghtIsValidRule;
        this.userPasswordHasANumberRule = userPasswordHasANumberRule;
        this.userPasswordHasSpecialCharacterRule = userPasswordHasSpecialCharacterRule;
    }

    @Override
    public void validate(UserDomain data) {
        userPasswordHasUppercaseRule.validate(data.getPassword());
        userPasswordHasSpecialCharacterRule.validate(data.getPassword());
        userPasswordLenghtIsValidRule.validate(data.getPassword());
        userPasswordHasANumberRule.validate(data.getPassword());
    }
}
