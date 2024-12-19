package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.domain.customers.exceptions.CustomerNameFormatIsNotValidException;
import co.inventory.system.ld.domain.customers.rules.CustomerNameFormatIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class CustomerNameFormatIsValidRuleImpl implements CustomerNameFormatIsValidRule {

    @Override
    public void validate(String data) {
        if (!data.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            throw CustomerNameFormatIsNotValidException.create();
        }
    }
}
