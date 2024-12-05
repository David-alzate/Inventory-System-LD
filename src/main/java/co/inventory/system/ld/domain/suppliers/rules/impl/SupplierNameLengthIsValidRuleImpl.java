package co.inventory.system.ld.domain.suppliers.rules.impl;

import co.inventory.system.ld.domain.suppliers.exceptions.SupplierNameLengthIsNotValidException;
import co.inventory.system.ld.domain.suppliers.rules.SupplierNameLengthIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class SupplierNameLengthIsValidRuleImpl implements SupplierNameLengthIsValidRule {
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 255;

    @Override
    public void validate(String data) {
        if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
            throw SupplierNameLengthIsNotValidException.create();
        }
    }
}
