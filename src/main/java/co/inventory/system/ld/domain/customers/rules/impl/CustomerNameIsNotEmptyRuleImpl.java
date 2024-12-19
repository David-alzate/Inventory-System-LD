package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.customers.exceptions.CustomerNameIsEmptyException;
import co.inventory.system.ld.domain.customers.rules.CustomerNameIsNotEmptyRule;
import org.springframework.stereotype.Service;

@Service
public class CustomerNameIsNotEmptyRuleImpl implements CustomerNameIsNotEmptyRule {

    @Override
    public void validate(String data) {
        if (ObjectHelper.isNull(data)){
            throw CustomerNameIsEmptyException.create();
        }
    }
}
