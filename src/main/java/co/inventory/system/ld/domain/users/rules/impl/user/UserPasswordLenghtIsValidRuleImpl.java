package co.inventory.system.ld.domain.users.rules.impl.user;

import co.inventory.system.ld.domain.users.exceptions.user.UserPasswordLenghtIsNotValidException;
import co.inventory.system.ld.domain.users.rules.user.UserPasswordLenghtIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class UserPasswordLenghtIsValidRuleImpl implements UserPasswordLenghtIsValidRule {

    private static final int MIN_NAME_LENGTH = 8;

    @Override
    public void validate(String data) {
        if (data.length() < MIN_NAME_LENGTH){
            throw UserPasswordLenghtIsNotValidException.create();
        }
    }
}
