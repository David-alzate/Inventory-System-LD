package co.inventory.system.ld.domain.suppliers.rules.impl;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.suppliers.exceptions.SupplierNameIsNullException;
import co.inventory.system.ld.domain.suppliers.rules.SupplierNameIsNotNullRule;
import org.springframework.stereotype.Service;

@Service
public class SupplierNameIsNotNullRuleImpl implements SupplierNameIsNotNullRule {

    @Override
    public void validate(String data) {
        if (TextHelper.isNull(data)) {
            throw SupplierNameIsNullException.create();
        }
    }
}
