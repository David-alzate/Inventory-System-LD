package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.product;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.DeleteProductRulesValidator;
import co.inventory.system.ld.domain.products.rules.product.ProductIdDoesExitsRule;

@Service
public class DeleteProductRulesValidatorImpl implements DeleteProductRulesValidator {

	private final ProductIdDoesExitsRule productIdDoesExitsRule;

	public DeleteProductRulesValidatorImpl(ProductIdDoesExitsRule productIdDoesExitsRule) {
		this.productIdDoesExitsRule = productIdDoesExitsRule;
	}

	@Override
	public void validate(UUID data) {
		productIdDoesExitsRule.validate(data);

	}

}
