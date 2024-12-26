package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.product;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductSuppliersRulesValidator;
import co.inventory.system.ld.domain.products.ProductDomain;
import co.inventory.system.ld.domain.suppliers.rules.SupplierIdDoesExistsRule;

@Service
public class RegisterNewProductSuppliersRulesValidatorImpl implements RegisterNewProductSuppliersRulesValidator {

	private final SupplierIdDoesExistsRule supplierIdDoesExistsRule;

	public RegisterNewProductSuppliersRulesValidatorImpl(SupplierIdDoesExistsRule supplierIdDoesExistsRule) {
		super();
		this.supplierIdDoesExistsRule = supplierIdDoesExistsRule;
	}

	@Override
	public void validate(ProductDomain data) {
		supplierIdDoesExistsRule.validate(data.getSupplier().getId());

	}

}
