package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.RegisterNewProductIdRulesValidator;
import co.inventory.system.ld.domain.products.ProductDomain;
import co.inventory.system.ld.domain.products.exceptions.ProductIdDoesExitsException;
import co.inventory.system.ld.domain.products.rules.ProductIdDoesNotExitsRule;

public class RegisterNewProductIdRulesValidatorImpl implements RegisterNewProductIdRulesValidator {

	private ProductIdDoesNotExitsRule productIdDoesNotExitsRule;

	public RegisterNewProductIdRulesValidatorImpl(ProductIdDoesNotExitsRule productIdDoesNotExitsRule) {
		this.productIdDoesNotExitsRule = productIdDoesNotExitsRule;
	}

	@Override
	public void validate(ProductDomain data) {
		data.generateId();
		try {
			productIdDoesNotExitsRule.validate(data.getId());
		} catch (final ProductIdDoesExitsException exception) {
			validate(data);
		}

	}

}
