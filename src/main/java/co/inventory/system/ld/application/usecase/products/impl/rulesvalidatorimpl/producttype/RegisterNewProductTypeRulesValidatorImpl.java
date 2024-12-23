package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.producttype;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.producttype.RegisterNewProductTypeIdRulesValidator;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.producttype.RegisterNewProductTypeRulesValidator;
import co.inventory.system.ld.domain.products.ProductTypeDomain;

@Service
public class RegisterNewProductTypeRulesValidatorImpl implements RegisterNewProductTypeRulesValidator {

	private final RegisterNewProductTypeIdRulesValidator registerNewProductTypeIdRulesValidator;

	public RegisterNewProductTypeRulesValidatorImpl(
			RegisterNewProductTypeIdRulesValidator registerNewProductTypeIdRulesValidator) {
		this.registerNewProductTypeIdRulesValidator = registerNewProductTypeIdRulesValidator;
	}

	@Override
	public void validate(ProductTypeDomain data) {
		registerNewProductTypeIdRulesValidator.validate(data);

	}

}
