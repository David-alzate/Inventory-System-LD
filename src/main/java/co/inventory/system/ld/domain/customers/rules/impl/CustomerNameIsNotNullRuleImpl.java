package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.customers.exceptions.CustomerNameIsNullException;
import co.inventory.system.ld.domain.customers.rules.CustomerNameIsNotNullRule;

public class CustomerNameIsNotNullRuleImpl implements CustomerNameIsNotNullRule {

    @Override
    public void validate(String data) {
        if (TextHelper.isNull(data)){
            throw CustomerNameIsNullException.create();
        }
    }
}
