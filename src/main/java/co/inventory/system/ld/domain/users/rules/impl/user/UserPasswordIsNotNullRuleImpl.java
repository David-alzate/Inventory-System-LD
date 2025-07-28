package co.inventory.system.ld.domain.users.rules.impl.user;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.users.exceptions.user.UserPasswordIsNullException;
import co.inventory.system.ld.domain.users.rules.user.UserPasswordIsNotNullRule;
import org.springframework.stereotype.Service;

@Service
public class UserPasswordIsNotNullRuleImpl implements UserPasswordIsNotNullRule {

    @Override
    public void validate(String data) {
        if (TextHelper.isEmpty(data)){
            throw UserPasswordIsNullException.create();
        }
    }
}
