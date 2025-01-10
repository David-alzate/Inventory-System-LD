package co.inventory.system.ld.application.usecase.suppliers.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.RegisterNewSupplierNameRulesValidator;
import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.RegisterNewSupplierStatusRulesValidator;
import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.UpdateSupplierRulesValidator;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;
import co.inventory.system.ld.domain.suppliers.rules.SupplierIdDoesExistsRule;

@Service
public class UpdateSupplierRulesValidatorImpl implements UpdateSupplierRulesValidator {

	private final SupplierIdDoesExistsRule supplierIdDoesExistsRule;
	private RegisterNewSupplierNameRulesValidator supplierNameRulesValidator;
	private RegisterNewSupplierStatusRulesValidator supplierStatusRulesValidator;

	public UpdateSupplierRulesValidatorImpl(SupplierIdDoesExistsRule supplierIdDoesExistsRule,
			RegisterNewSupplierNameRulesValidator supplierNameRulesValidator,
			RegisterNewSupplierStatusRulesValidator supplierStatusRulesValidator) {
		this.supplierIdDoesExistsRule = supplierIdDoesExistsRule;
		this.supplierNameRulesValidator = supplierNameRulesValidator;
		this.supplierStatusRulesValidator = supplierStatusRulesValidator;
	}

	@Override
	public void validate(SupplierDomain data) {
		supplierIdDoesExistsRule.validate(data.getId());
		supplierNameRulesValidator.validate(data);
		supplierStatusRulesValidator.validate(data);

	}

}
