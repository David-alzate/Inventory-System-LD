package co.inventory.system.ld.domain.products.rules.impl.producttype;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.domain.products.exceptions.producttype.ProductTypeNameFormatIsNotValidException;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeNameFormatIsValidRule;

@Service
public class ProductTypeNameFormatIsValidRuleImpl implements ProductTypeNameFormatIsValidRule {

    @Override
    public void validate(String data) {
        if (!data.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            throw ProductTypeNameFormatIsNotValidException.create();
        }
    }
}
