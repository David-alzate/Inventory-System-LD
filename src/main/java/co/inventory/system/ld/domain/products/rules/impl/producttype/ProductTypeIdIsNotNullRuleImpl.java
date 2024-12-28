package co.inventory.system.ld.domain.products.rules.impl.producttype;

import java.util.UUID;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.products.exceptions.producttype.ProductTypeIdIsNullException;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeIdIsNotNullRule;

public class ProductTypeIdIsNotNullRuleImpl implements ProductTypeIdIsNotNullRule {
    @Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)){
            throw ProductTypeIdIsNullException.create();
        }
    }
}
