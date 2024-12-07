package co.inventory.system.ld.domain.users.rules.impl;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.users.exceptions.UserNameIsEmpyException;
import co.inventory.system.ld.domain.users.rules.UserNameIsNotEmpyRule;
import org.springframework.stereotype.Service;

@Service
public class UserNameIsNotEmpyRuleImpl implements UserNameIsNotEmpyRule {

    @Override
    public void validate(String data) {
        if (TextHelper.isEmpty(data)) {
            throw UserNameIsEmpyException.create();
        }
    }
}
