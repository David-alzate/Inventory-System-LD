package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.crosscutting.helpers.NumericHelper;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import co.inventory.system.ld.domain.customers.exceptions.CustomerIdNumberLenghIsNotValidException;
import co.inventory.system.ld.domain.customers.rules.CustomerIdNumberLenghtIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class CustomerIdNumberLenghtIsValidRuleImpl implements CustomerIdNumberLenghtIsValidRule {

    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 15;

    @Override
    public void validate(CustomerDomain data) {
        int length = data.getIdNumber().toString().length();

        if (!NumericHelper.isBetween(length,MIN_LENGTH,MAX_LENGTH,true,true)){
            throw CustomerIdNumberLenghIsNotValidException.create();
        }
    }
}
