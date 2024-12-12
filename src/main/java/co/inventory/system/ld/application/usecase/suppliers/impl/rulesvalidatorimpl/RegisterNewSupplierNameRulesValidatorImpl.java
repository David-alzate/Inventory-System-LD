package co.inventory.system.ld.application.usecase.suppliers.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.RegisterNewSupplierNameRulesValidator;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;
import co.inventory.system.ld.domain.suppliers.rules.SupplierNameFormatIsValidRule;
import co.inventory.system.ld.domain.suppliers.rules.SupplierNameIsNotEmptyRule;
import co.inventory.system.ld.domain.suppliers.rules.SupplierNameIsNotNullRule;
import co.inventory.system.ld.domain.suppliers.rules.SupplierNameLengthIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewSupplierNameRulesValidatorImpl implements RegisterNewSupplierNameRulesValidator {

    private SupplierNameFormatIsValidRule supplierNameFormatIsValidRule;
    private SupplierNameIsNotNullRule supplierNameIsNotNullRule;
    private SupplierNameIsNotEmptyRule supplierNameIsNotEmptyRule;
    private SupplierNameLengthIsValidRule supplierNameLengthIsValidRule;

    public RegisterNewSupplierNameRulesValidatorImpl(SupplierNameFormatIsValidRule supplierNameFormatIsValidRule, SupplierNameIsNotNullRule supplierNameIsNotNullRule, SupplierNameIsNotEmptyRule supplierNameIsNotEmptyRule, SupplierNameLengthIsValidRule supplierNameLengthIsValidRule) {
        this.supplierNameFormatIsValidRule = supplierNameFormatIsValidRule;
        this.supplierNameIsNotNullRule = supplierNameIsNotNullRule;
        this.supplierNameIsNotEmptyRule = supplierNameIsNotEmptyRule;
        this.supplierNameLengthIsValidRule = supplierNameLengthIsValidRule;
    }

    @Override
    public void validate(SupplierDomain data) {
        supplierNameFormatIsValidRule.validate(data.getName());
        supplierNameIsNotNullRule.validate(data.getName());
        supplierNameIsNotEmptyRule.validate(data.getName());
        supplierNameLengthIsValidRule.validate(data.getName());
    }
}
