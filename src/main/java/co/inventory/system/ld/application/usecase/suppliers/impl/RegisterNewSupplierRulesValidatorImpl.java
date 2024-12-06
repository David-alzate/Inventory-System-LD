package co.inventory.system.ld.application.usecase.suppliers.impl;

import co.inventory.system.ld.application.usecase.suppliers.RegisterNewSupplierIdRulesValidator;
import co.inventory.system.ld.application.usecase.suppliers.RegisterNewSupplierNameRulesValidator;
import co.inventory.system.ld.application.usecase.suppliers.RegisterNewSupplierRulesValidator;
import co.inventory.system.ld.application.usecase.suppliers.RegisterNewSupplierStatusRulesValidator;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;

public class RegisterNewSupplierRulesValidatorImpl implements RegisterNewSupplierRulesValidator {

    private RegisterNewSupplierIdRulesValidator supplierIdRulesValidator;
    private RegisterNewSupplierStatusRulesValidator supplierStatusRulesValidator;;
    private RegisterNewSupplierNameRulesValidator supplierNameRulesValidator;

    public RegisterNewSupplierRulesValidatorImpl(RegisterNewSupplierIdRulesValidator supplierIdRulesValidator, RegisterNewSupplierStatusRulesValidator supplierStatusRulesValidator, RegisterNewSupplierNameRulesValidator supplierNameRulesValidator) {
        this.supplierIdRulesValidator = supplierIdRulesValidator;
        this.supplierStatusRulesValidator = supplierStatusRulesValidator;
        this.supplierNameRulesValidator = supplierNameRulesValidator;
    }

    @Override
    public void validate(SupplierDomain data) {
        supplierNameRulesValidator.validate(data);
        supplierIdRulesValidator.validate(data);
        supplierStatusRulesValidator.validate(data.getStatus().getId());
    }
}
