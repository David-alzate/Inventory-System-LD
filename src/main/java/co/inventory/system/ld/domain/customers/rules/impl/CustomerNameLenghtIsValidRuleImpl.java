package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.domain.customers.exceptions.CustomerNameLenghtIsNotValidException;
import co.inventory.system.ld.domain.customers.rules.CustomerNameLenghtIsValidRule;

public class CustomerNameLenghtIsValidRuleImpl implements CustomerNameLenghtIsValidRule {

    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 50;

    @Override
    public void validate(String data) {
        if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
            throw CustomerNameLenghtIsNotValidException.create();
        }
    }
}
