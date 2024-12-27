package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.product;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductIdRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductNameRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductProductTypeRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductSuppliersRulesValidator;
import co.inventory.system.ld.domain.products.ProductDomain;

@Service
public class RegisterNewProductRulesValidatorImpl implements RegisterNewProductRulesValidator {

	private final RegisterNewProductIdRulesValidator registerNewProductIdRulesValidator;
	private final RegisterNewProductNameRulesValidator registerNewProductNameRulesValidator;
	private final RegisterNewProductSuppliersRulesValidator registerNewProductSuppliersRulesValidator;
	private final RegisterNewProductProductTypeRulesValidator registerNewProductProductTypeRulesValidator;

	public RegisterNewProductRulesValidatorImpl(RegisterNewProductIdRulesValidator registerNewProductIdRulesValidator,
			RegisterNewProductNameRulesValidator registerNewProductNameRulesValidator,
			RegisterNewProductSuppliersRulesValidator registerNewProductSuppliersRulesValidator,
			RegisterNewProductProductTypeRulesValidator registerNewProductProductTypeRulesValidator) {
		this.registerNewProductIdRulesValidator = registerNewProductIdRulesValidator;
		this.registerNewProductNameRulesValidator = registerNewProductNameRulesValidator;
		this.registerNewProductSuppliersRulesValidator = registerNewProductSuppliersRulesValidator;
		this.registerNewProductProductTypeRulesValidator = registerNewProductProductTypeRulesValidator;
	}

	@Override
	public void validate(ProductDomain data) {
		registerNewProductIdRulesValidator.validate(data);
		registerNewProductNameRulesValidator.validate(data);
		registerNewProductSuppliersRulesValidator.validate(data);
		registerNewProductProductTypeRulesValidator.validate(data);

	}

}
