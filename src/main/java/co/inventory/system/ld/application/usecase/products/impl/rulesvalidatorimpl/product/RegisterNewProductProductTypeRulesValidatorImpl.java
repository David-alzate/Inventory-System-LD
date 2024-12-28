package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.product;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductProductTypeRulesValidator;
import co.inventory.system.ld.domain.products.ProductDomain;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeIdDoesExistsRule;

@Service
public class RegisterNewProductProductTypeRulesValidatorImpl implements RegisterNewProductProductTypeRulesValidator {

	private final ProductTypeIdDoesExistsRule productTypeIdDoesExistsRule;

	public RegisterNewProductProductTypeRulesValidatorImpl(ProductTypeIdDoesExistsRule productTypeIdDoesExistsRule) {
		this.productTypeIdDoesExistsRule = productTypeIdDoesExistsRule;
	}

	@Override
	public void validate(ProductDomain data) {
		productTypeIdDoesExistsRule.validate(data.getProductType().getId());

	}

}
