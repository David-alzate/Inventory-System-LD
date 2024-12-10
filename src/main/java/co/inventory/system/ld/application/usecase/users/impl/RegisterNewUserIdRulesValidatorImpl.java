package co.inventory.system.ld.application.usecase.users.impl;

import co.inventory.system.ld.application.usecase.users.RegisterNewUserIdRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.exceptions.UserIdDoesExistsException;
import co.inventory.system.ld.domain.users.rules.UserIdDoesNotExistsRule;
import co.inventory.system.ld.domain.users.rules.UserIdIsNotNullRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewUserIdRulesValidatorImpl implements RegisterNewUserIdRulesValidator {

    private final UserIdDoesNotExistsRule userIdDoesNotExistsRule;
    private final UserIdIsNotNullRule userIdIsNotNullRule;

    public RegisterNewUserIdRulesValidatorImpl(UserIdDoesNotExistsRule userIdDoesNotExistsRule, UserIdIsNotNullRule userIdIsNotNullRule) {
        this.userIdDoesNotExistsRule = userIdDoesNotExistsRule;
        this.userIdIsNotNullRule = userIdIsNotNullRule;
    }

    @Override
    public void validate(UserDomain data) {
        userIdIsNotNullRule.validate(data.getId());
        data.generateId();
        try {
            userIdDoesNotExistsRule.validate(data.getId());
        } catch (final UserIdDoesExistsException exception) {
            validate(data);
        }
    }
}
