package co.inventory.system.ld.application.usecase.suppliers.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.RegisterNewSupplierStatusRulesValidator;
import co.inventory.system.ld.domain.commons.rules.status.StatusIdDoesExistsRule;
import co.inventory.system.ld.domain.commons.rules.status.StatusIdIsNotDefaultValueRule;
import co.inventory.system.ld.domain.commons.rules.status.StatusIdIsNotNullRule;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;

@Service
public class RegisterNewSupplierStatusRulesValidatorImpl implements RegisterNewSupplierStatusRulesValidator {

	private final StatusIdDoesExistsRule statusIdDoesExistsRule;
	private final StatusIdIsNotDefaultValueRule statusIdIsNotDefaultValueRule;
	private final StatusIdIsNotNullRule statusIdIsNotNullRule;

	public RegisterNewSupplierStatusRulesValidatorImpl(StatusIdDoesExistsRule statusIdDoesExistsRule,
			StatusIdIsNotDefaultValueRule statusIdIsNotDefaultValueRule, StatusIdIsNotNullRule statusIdIsNotNullRule) {
		this.statusIdDoesExistsRule = statusIdDoesExistsRule;
		this.statusIdIsNotDefaultValueRule = statusIdIsNotDefaultValueRule;
		this.statusIdIsNotNullRule = statusIdIsNotNullRule;
	}

	@Override
	public void validate(SupplierDomain data) {
		statusIdDoesExistsRule.validate(data.getStatus().getId());
		statusIdIsNotDefaultValueRule.validate(data.getStatus().getId());
		statusIdIsNotNullRule.validate(data.getStatus().getId());

	}

}
