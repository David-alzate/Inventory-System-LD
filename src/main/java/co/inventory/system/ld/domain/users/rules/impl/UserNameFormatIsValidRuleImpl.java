package co.inventory.system.ld.domain.users.rules.impl;

import co.inventory.system.ld.domain.users.exceptions.UserNameFormatIsNotValidException;
import co.inventory.system.ld.domain.users.rules.UserNameFormatIsValidRule;
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
