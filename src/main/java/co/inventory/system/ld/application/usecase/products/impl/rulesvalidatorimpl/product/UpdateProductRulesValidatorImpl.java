package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.product;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductNameRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductProductTypeRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductSuppliersRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.UpdateProductRulesValidator;
import co.inventory.system.ld.domain.products.ProductDomain;
import co.inventory.system.ld.domain.products.rules.product.ProductIdDoesExitsRule;

@Service
public class UpdateProductRulesValidatorImpl implements UpdateProductRulesValidator {

	private final ProductIdDoesExitsRule productIdDoesExitsRule;
	private final RegisterNewProductNameRulesValidator registerNewProductNameRulesValidator;
	private final RegisterNewProductSuppliersRulesValidator registerNewProductSuppliersRulesValidator;
	private final RegisterNewProductProductTypeRulesValidator registerNewProductProductTypeRulesValidator;

	public UpdateProductRulesValidatorImpl(ProductIdDoesExitsRule productIdDoesExitsRule,
			RegisterNewProductNameRulesValidator registerNewProductNameRulesValidator,
			RegisterNewProductSuppliersRulesValidator registerNewProductSuppliersRulesValidator,
			RegisterNewProductProductTypeRulesValidator registerNewProductProductTypeRulesValidator) {
		this.productIdDoesExitsRule = productIdDoesExitsRule;
		this.registerNewProductNameRulesValidator = registerNewProductNameRulesValidator;
		this.registerNewProductSuppliersRulesValidator = registerNewProductSuppliersRulesValidator;
		this.registerNewProductProductTypeRulesValidator = registerNewProductProductTypeRulesValidator;
	}

	@Override
	public void validate(ProductDomain data) {
		productIdDoesExitsRule.validate(data.getId());
		registerNewProductNameRulesValidator.validate(data);
		registerNewProductSuppliersRulesValidator.validate(data);
		registerNewProductProductTypeRulesValidator.validate(data);

	}

}
