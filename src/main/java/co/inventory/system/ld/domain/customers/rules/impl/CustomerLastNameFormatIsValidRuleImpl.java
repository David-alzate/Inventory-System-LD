package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.domain.customers.exceptions.CustomerLastNameFormatIsNotValidException;
import co.inventory.system.ld.domain.customers.rules.CustomerLastNameFormatIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class CustomerLastNameFormatIsValidRuleImpl implements CustomerLastNameFormatIsValidRule {

    @Override
    public void validate(String data) {
        if (!data.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            throw CustomerLastNameFormatIsNotValidException.create();
        }
    }
}
