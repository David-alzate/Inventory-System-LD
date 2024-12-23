package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.product;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductIdRulesValidator;
import co.inventory.system.ld.domain.products.ProductDomain;
import co.inventory.system.ld.domain.products.exceptions.product.ProductIdDoesExitsException;
import co.inventory.system.ld.domain.products.rules.product.ProductIdDoesNotExitsRule;

@Service
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
