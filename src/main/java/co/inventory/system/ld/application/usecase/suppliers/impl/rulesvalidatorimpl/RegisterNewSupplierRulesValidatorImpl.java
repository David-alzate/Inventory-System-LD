package co.inventory.system.ld.application.usecase.suppliers.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.RegisterNewSupplierIdRulesValidator;
import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.RegisterNewSupplierNameRulesValidator;
import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.RegisterNewSupplierRulesValidator;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewSupplierRulesValidatorImpl implements RegisterNewSupplierRulesValidator {

    private RegisterNewSupplierIdRulesValidator supplierIdRulesValidator;
    private RegisterNewSupplierNameRulesValidator supplierNameRulesValidator;

    public RegisterNewSupplierRulesValidatorImpl(RegisterNewSupplierIdRulesValidator supplierIdRulesValidator, RegisterNewSupplierNameRulesValidator supplierNameRulesValidator) {
        this.supplierIdRulesValidator = supplierIdRulesValidator;
        this.supplierNameRulesValidator = supplierNameRulesValidator;
    }

    @Override
    public void validate(SupplierDomain data) {
        supplierNameRulesValidator.validate(data);
        supplierIdRulesValidator.validate(data);
    }
}
