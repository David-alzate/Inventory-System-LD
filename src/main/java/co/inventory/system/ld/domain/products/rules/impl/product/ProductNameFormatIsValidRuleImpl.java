package co.inventory.system.ld.domain.products.rules.impl.product;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.domain.products.exceptions.product.ProductNameFormatIsNotValidException;
import co.inventory.system.ld.domain.products.rules.product.ProductNameFormatIsValidRule;

@Service
public class ProductNameFormatIsValidRuleImpl implements ProductNameFormatIsValidRule {

    @Override
    public void validate(String data) {
        if (!data.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            throw ProductNameFormatIsNotValidException.create();
        }
    }
}
