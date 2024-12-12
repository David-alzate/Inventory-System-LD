package co.inventory.system.ld.domain.suppliers.rules.impl;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.suppliers.exceptions.SupplierNameIsEmptyException;
import co.inventory.system.ld.domain.suppliers.rules.SupplierNameIsNotEmptyRule;
import org.springframework.stereotype.Service;

@Service
public class SupplierNameIsNotEmptyRuleImpl implements SupplierNameIsNotEmptyRule {

    @Override
    public void validate(String data) {
        if (TextHelper.isEmpty(data)) {
            throw SupplierNameIsEmptyException.create();
        }
    }
}
