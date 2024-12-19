package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.customers.exceptions.CustomerLastNameIsNullException;
import co.inventory.system.ld.domain.customers.rules.CustomerLastNameIsNotNullRule;
import org.springframework.stereotype.Service;

@Service
public class CustomerLastNameIsNotNullRuleImpl implements CustomerLastNameIsNotNullRule {

    @Override
    public void validate(String data) {
        if(ObjectHelper.isNull(data)){
            throw CustomerLastNameIsNullException.create();
        }
    }
}
