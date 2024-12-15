package co.inventory.system.ld.domain.users.rules.impl.user;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.users.exceptions.user.UserIdIsNullException;
import co.inventory.system.ld.domain.users.rules.user.UserIdIsNotNullRule;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserIdIsNotNullRuleImpl implements UserIdIsNotNullRule {

    @Override
    public void validate(UUID data) {

        if(ObjectHelper.isNull(data)) {
            throw UserIdIsNullException.create();
        }
    }
}
