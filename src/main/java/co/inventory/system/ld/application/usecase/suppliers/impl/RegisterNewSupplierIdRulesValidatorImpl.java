package co.inventory.system.ld.application.usecase.suppliers.impl;

import co.inventory.system.ld.application.usecase.suppliers.RegisterNewSupplierIdRulesValidator;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;
import co.inventory.system.ld.domain.suppliers.exceptions.SupplierIdDoesExistException;
import co.inventory.system.ld.domain.suppliers.rules.SupplierIdDoesNotExistsRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewSupplierIdRulesValidatorImpl implements RegisterNewSupplierIdRulesValidator {

    private SupplierIdDoesNotExistsRule supplierIdDoesNotExistsRule;

    public RegisterNewSupplierIdRulesValidatorImpl(SupplierIdDoesNotExistsRule supplierIdDoesNotExistsRule) {
        this.supplierIdDoesNotExistsRule = supplierIdDoesNotExistsRule;
    }

    @Override
    public void validate(SupplierDomain data) {
        data.generateId();
        try {
            supplierIdDoesNotExistsRule.validate(data.getId());
        } catch (final SupplierIdDoesExistException exception) {
            validate(data);
        }
    }
}
