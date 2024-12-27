package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.producttype;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.producttype.RegisterNewProductTypeNameRulesValidator;
import co.inventory.system.ld.domain.products.ProductTypeDomain;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeNameFormatIsValidRule;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeNameIsNotEmpyRule;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeNameIsNotNullRule;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeNameLenghIsValidRule;

@Service
public class RegisterNewProductTypeNameRulesValidatorImpl implements RegisterNewProductTypeNameRulesValidator {

	private final ProductTypeNameFormatIsValidRule productTypeNameFormatIsValidRule;
	private final ProductTypeNameIsNotEmpyRule productTypeNameIsNotEmpyRule;
	private final ProductTypeNameLenghIsValidRule productTypeNameLenghIsValidRule;
	private final ProductTypeNameIsNotNullRule productTypeNameIsNotNullRule;

	public RegisterNewProductTypeNameRulesValidatorImpl(
			ProductTypeNameFormatIsValidRule productTypeNameFormatIsValidRule,
			ProductTypeNameIsNotEmpyRule productTypeNameIsNotEmpyRule,
			ProductTypeNameLenghIsValidRule productTypeNameLenghIsValidRule,
			ProductTypeNameIsNotNullRule productTypeNameIsNotNullRule) {
		this.productTypeNameFormatIsValidRule = productTypeNameFormatIsValidRule;
		this.productTypeNameIsNotEmpyRule = productTypeNameIsNotEmpyRule;
		this.productTypeNameLenghIsValidRule = productTypeNameLenghIsValidRule;
		this.productTypeNameIsNotNullRule = productTypeNameIsNotNullRule;
	}

	@Override
	public void validate(ProductTypeDomain data) {
		productTypeNameFormatIsValidRule.validate(data.getName());
		productTypeNameIsNotEmpyRule.validate(data.getName());
		productTypeNameLenghIsValidRule.validate(data.getName());
		productTypeNameIsNotNullRule.validate(data.getName());

	}
}
