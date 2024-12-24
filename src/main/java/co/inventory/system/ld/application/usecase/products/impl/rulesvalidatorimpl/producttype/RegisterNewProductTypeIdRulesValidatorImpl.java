package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.producttype;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.producttype.RegisterNewProductTypeIdRulesValidator;
import co.inventory.system.ld.domain.products.ProductTypeDomain;
import co.inventory.system.ld.domain.products.exceptions.producttype.ProductTypeIdDoesExitsException;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeIdDoesNotExitsRule;

@Service
public class RegisterNewProductTypeIdRulesValidatorImpl implements RegisterNewProductTypeIdRulesValidator {

	private ProductTypeIdDoesNotExitsRule productTypeIdDoesNotExitsRule;

	public RegisterNewProductTypeIdRulesValidatorImpl(ProductTypeIdDoesNotExitsRule productTypeIdDoesNotExitsRule) {
		super();
		this.productTypeIdDoesNotExitsRule = productTypeIdDoesNotExitsRule;
	}

	@Override
	public void validate(ProductTypeDomain data) {
		data.generateId();
		try {
			productTypeIdDoesNotExitsRule.validate(data.getId());
		} catch (final ProductTypeIdDoesExitsException exception) {
			validate(data);
		}

	}

}
