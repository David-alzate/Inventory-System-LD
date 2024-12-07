package co.inventory.system.ld.domain.users.rules.impl;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.users.exceptions.UserIdIsNullException;
import co.inventory.system.ld.domain.users.rules.UserIdIsNotNullRule;
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
