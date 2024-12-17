package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.customers.exceptions.CustomerLastNameIsEmptyException;
import co.inventory.system.ld.domain.customers.rules.CustomerLastNameIsNotEmptyRule;
import org.springframework.stereotype.Service;

@Service
public class CustomerLastNameIsNotEmptyRuleImpl implements CustomerLastNameIsNotEmptyRule {

    @Override
    public void validate(String data) {
        if (TextHelper.isEmpty(data)){
            throw CustomerLastNameIsEmptyException.create();
        }
    }
}
