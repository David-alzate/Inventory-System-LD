package co.inventory.system.ld.application.usecase.suppliers.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.RegisterNewSupplierIdRulesValidator;
import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.RegisterNewSupplierNameRulesValidator;
import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.RegisterNewSupplierRulesValidator;
import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.RegisterNewSupplierStatusRulesValidator;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;

@Service
public class RegisterNewSupplierRulesValidatorImpl implements RegisterNewSupplierRulesValidator {

	private RegisterNewSupplierIdRulesValidator supplierIdRulesValidator;
	private RegisterNewSupplierNameRulesValidator supplierNameRulesValidator;
	private RegisterNewSupplierStatusRulesValidator supplierStatusRulesValidator;

	public RegisterNewSupplierRulesValidatorImpl(RegisterNewSupplierIdRulesValidator supplierIdRulesValidator,
			RegisterNewSupplierNameRulesValidator supplierNameRulesValidator,
			RegisterNewSupplierStatusRulesValidator supplierStatusRulesValidator) {
		this.supplierIdRulesValidator = supplierIdRulesValidator;
		this.supplierNameRulesValidator = supplierNameRulesValidator;
		this.supplierStatusRulesValidator = supplierStatusRulesValidator;
	}

	@Override
	public void validate(SupplierDomain data) {
		supplierNameRulesValidator.validate(data);
		supplierIdRulesValidator.validate(data);
		supplierStatusRulesValidator.validate(data);
	}
}
