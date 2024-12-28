package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.producttype;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.producttype.RegisterNewProductTypeIdRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.producttype.RegisterNewProductTypeNameRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.producttype.RegisterNewProductTypeRulesValidator;
import co.inventory.system.ld.domain.products.ProductTypeDomain;

@Service
public class RegisterNewProductTypeRulesValidatorImpl implements RegisterNewProductTypeRulesValidator {

	private final RegisterNewProductTypeIdRulesValidator registerNewProductTypeIdRulesValidator;
	private final RegisterNewProductTypeNameRulesValidator registerNewProductTypeNameRulesValidator;

	public RegisterNewProductTypeRulesValidatorImpl(
			RegisterNewProductTypeIdRulesValidator registerNewProductTypeIdRulesValidator,
			RegisterNewProductTypeNameRulesValidator registerNewProductTypeNameRulesValidator) {
		this.registerNewProductTypeIdRulesValidator = registerNewProductTypeIdRulesValidator;
		this.registerNewProductTypeNameRulesValidator = registerNewProductTypeNameRulesValidator;
	}

	@Override
	public void validate(ProductTypeDomain data) {
		registerNewProductTypeIdRulesValidator.validate(data);
		registerNewProductTypeNameRulesValidator.validate(data);

	}

}
