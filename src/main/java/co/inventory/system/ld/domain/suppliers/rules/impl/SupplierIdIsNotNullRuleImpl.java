package co.inventory.system.ld.domain.suppliers.rules.impl;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.suppliers.exceptions.SupplierIdIsNullException;
import co.inventory.system.ld.domain.suppliers.rules.SupplierIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SupplierIdIsNotNullRuleImpl implements SupplierIdIsNotNullRule {

    @Override
    public void validate(UUID data) {
        if(ObjectHelper.isNull(data)){
            throw SupplierIdIsNullException.create();
        }
    }
}
