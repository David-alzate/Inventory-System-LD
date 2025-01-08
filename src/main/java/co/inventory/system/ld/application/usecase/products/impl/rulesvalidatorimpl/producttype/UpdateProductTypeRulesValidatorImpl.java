package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.producttype;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.producttype.RegisterNewProductTypeNameRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.producttype.UpdateProductTypeRulesValidator;
import co.inventory.system.ld.domain.products.ProductTypeDomain;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeIdDoesExistsRule;

@Service
public class UpdateProductTypeRulesValidatorImpl implements UpdateProductTypeRulesValidator {

	private final ProductTypeIdDoesExistsRule productTypeIdDoesExistsRule;
	private final RegisterNewProductTypeNameRulesValidator registerNewProductTypeNameRulesValidator;

	public UpdateProductTypeRulesValidatorImpl(ProductTypeIdDoesExistsRule productTypeIdDoesExistsRule,
			RegisterNewProductTypeNameRulesValidator registerNewProductTypeNameRulesValidator) {
		this.productTypeIdDoesExistsRule = productTypeIdDoesExistsRule;
		this.registerNewProductTypeNameRulesValidator = registerNewProductTypeNameRulesValidator;
	}

	@Override
	public void validate(ProductTypeDomain data) {
		productTypeIdDoesExistsRule.validate(data.getId());
		registerNewProductTypeNameRulesValidator.validate(data);

	}

}
