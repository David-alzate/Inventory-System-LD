package co.inventory.system.ld.domain.users.rules.impl.user;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.users.exceptions.user.UserNameIsNullException;
import co.inventory.system.ld.domain.users.rules.user.UserNameIsNotNullRule;

import org.springframework.stereotype.Service;

@Service
public class UserNameIsNotNullRuleImpl implements UserNameIsNotNullRule {

    @Override
    public void validate(String data) {
        if (TextHelper.isNull(data)) {
            throw UserNameIsNullException.create();
        }
    }
}
