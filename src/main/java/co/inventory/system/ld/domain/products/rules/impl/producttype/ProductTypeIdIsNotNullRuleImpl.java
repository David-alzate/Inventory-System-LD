package co.inventory.system.ld.domain.products.rules.impl.producttype;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.customers.exceptions.CustomerIdIsNullException;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeIdIsNotNullRule;

import java.util.UUID;

public class ProductTypeIdIsNotNullRuleImpl implements ProductTypeIdIsNotNullRule {
    @Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)){
            throw CustomerIdIsNullException.create();
        }
    }
}
