package co.inventory.system.ld.domain.suppliers.rules.impl;

import co.inventory.system.ld.domain.suppliers.exceptions.SupplierNameFormatIsNotValidException;
import co.inventory.system.ld.domain.suppliers.rules.SupplierNameFormatIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class SupplierNameFormatIsValidRuleImpl implements SupplierNameFormatIsValidRule {

    @Override
    public void validate(String data) {
        if (!data.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            throw SupplierNameFormatIsNotValidException.create();
        }
    }
}
