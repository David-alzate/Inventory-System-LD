package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.product;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductIdRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductRulesValidator;
import co.inventory.system.ld.domain.products.ProductDomain;

@Service
public class RegisterNewProductRulesValidatorImpl implements RegisterNewProductRulesValidator {

	private final RegisterNewProductIdRulesValidator registerNewProductIdRulesValidator;

	public RegisterNewProductRulesValidatorImpl(RegisterNewProductIdRulesValidator registerNewProductIdRulesValidator) {
		this.registerNewProductIdRulesValidator = registerNewProductIdRulesValidator;
	}

	@Override
	public void validate(ProductDomain data) {
		registerNewProductIdRulesValidator.validate(data);

	}

}
