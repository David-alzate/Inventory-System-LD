package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.product;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductNameRulesValidator;
import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductIdRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductRulesValidator;
import co.inventory.system.ld.domain.products.ProductDomain;

@Service
public class RegisterNewProductRulesValidatorImpl implements RegisterNewProductRulesValidator {

	private final RegisterNewProductIdRulesValidator registerNewProductIdRulesValidator;
	private final RegisterNewProductNameRulesValidator registerNewProductNameRulesValidator;

	public RegisterNewProductRulesValidatorImpl(RegisterNewProductIdRulesValidator registerNewProductIdRulesValidator, RegisterNewProductNameRulesValidator registerNewProductNameRulesValidator) {
		this.registerNewProductIdRulesValidator = registerNewProductIdRulesValidator;
		this.registerNewProductNameRulesValidator = registerNewProductNameRulesValidator;
	}

	@Override
	public void validate(ProductDomain data) {
		registerNewProductIdRulesValidator.validate(data);
		registerNewProductNameRulesValidator.validate(data);

	}

}
