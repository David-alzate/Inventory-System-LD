package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.customers.exceptions.CustomerNameIsNullException;
import co.inventory.system.ld.domain.customers.rules.CustomerNameIsNotNullRule;
import org.springframework.stereotype.Service;

@Service
public class CustomerNameIsNotNullRuleImpl implements CustomerNameIsNotNullRule {

    @Override
    public void validate(String data) {
        if (TextHelper.isNull(data)){
            throw CustomerNameIsNullException.create();
        }
    }
}
