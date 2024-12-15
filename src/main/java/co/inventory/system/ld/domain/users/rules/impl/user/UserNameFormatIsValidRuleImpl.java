package co.inventory.system.ld.domain.users.rules.impl.user;

import co.inventory.system.ld.domain.users.exceptions.user.UserNameFormatIsNotValidException;
import co.inventory.system.ld.domain.users.rules.user.UserNameFormatIsValidRule;

import org.springframework.stereotype.Service;

@Service
public class UserNameFormatIsValidRuleImpl implements UserNameFormatIsValidRule {

    @Override
    public void validate(String data) {
        if (!data.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            throw UserNameFormatIsNotValidException.create();
        }
    }
}
