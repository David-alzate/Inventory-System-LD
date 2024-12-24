package co.inventory.system.ld.domain.products.rules.impl.product;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.products.exceptions.product.ProductNameIsNullException;
import co.inventory.system.ld.domain.products.rules.product.ProductNameIsNotNullRule;

@Service
public class ProductNameIsNotNullRuleImpl implements ProductNameIsNotNullRule {

	@Override
	public void validate(String data) {
		if (TextHelper.isNull(data)) {
			throw ProductNameIsNullException.create();
		}
	}
}
