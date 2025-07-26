package co.inventory.system.ld.domain.users.rules.impl.user;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.users.exceptions.user.UserPasswordIsEmptyException;
import co.inventory.system.ld.domain.users.rules.user.UserPasswordIsNotEmptyRule;
import org.springframework.stereotype.Service;

@Service
public class UserPasswordIsNotEmptyRuleImpl implements UserPasswordIsNotEmptyRule {
    @Override
    public void validate(String data) {
        if (TextHelper.isNull(data)){
            throw UserPasswordIsEmptyException.create();
        }
    }
}
