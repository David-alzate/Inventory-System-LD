package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.domain.customers.exceptions.CustomerLastNameFormatIsNotValidException;
import co.inventory.system.ld.domain.customers.rules.CustomerLastNameLenghtIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class CustomerLastNameLenghtIsValidRuleImpl implements CustomerLastNameLenghtIsValidRule {

    private static final int MIN_LASTNAME_LENGTH = 5;
    private static final int MAX_LASTNAME_LENGTH = 15;

    @Override
    public void validate(String data) {
        if (data.length() < MIN_LASTNAME_LENGTH || data.length() > MAX_LASTNAME_LENGTH) {
            throw CustomerLastNameFormatIsNotValidException.create();
        }
    }
}
