package co.inventory.system.ld.domain.products.rules.impl.product;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.products.exceptions.product.ProductNameIsEmpyException;
import co.inventory.system.ld.domain.products.rules.product.ProductNameIsNotEmpyRule;

@Service
public class ProductNameIsNotEmpyRuleImpl implements ProductNameIsNotEmpyRule {

    @Override
    public void validate(String data) {
        if (TextHelper.isEmpty(data)) {
            throw ProductNameIsEmpyException.create();
        }
    }
}
