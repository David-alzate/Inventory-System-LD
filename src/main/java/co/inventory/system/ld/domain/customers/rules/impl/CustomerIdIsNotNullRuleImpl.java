package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.customers.exceptions.CustomerIdIsNullException;
import co.inventory.system.ld.domain.customers.rules.CustomerIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerIdIsNotNullRuleImpl implements CustomerIdIsNotNullRule {

    @Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)){
            throw CustomerIdIsNullException.create();
        }
    }
}
