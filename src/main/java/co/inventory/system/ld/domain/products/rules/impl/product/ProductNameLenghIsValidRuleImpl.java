package co.inventory.system.ld.domain.products.rules.impl.product;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.domain.products.exceptions.product.ProductNameLenghIsNotValidException;
import co.inventory.system.ld.domain.products.rules.product.ProductNameLenghIsValidRule;

@Service
public class ProductNameLenghIsValidRuleImpl implements ProductNameLenghIsValidRule {

    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 50;

    @Override
    public void validate(String data) {
        if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
            throw ProductNameLenghIsNotValidException.create();
        }
    }
}
