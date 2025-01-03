package co.inventory.system.ld.domain.users.rules.impl.user;

import co.inventory.system.ld.domain.users.exceptions.user.UserNameLenghIsNotValidException;
import co.inventory.system.ld.domain.users.rules.user.UserNameLenghIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class UserNameLenghIsValidRuleImpl implements UserNameLenghIsValidRule {

    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 50;

    @Override
    public void validate(String data) {
        if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
            throw UserNameLenghIsNotValidException.create();
        }
    }
}
