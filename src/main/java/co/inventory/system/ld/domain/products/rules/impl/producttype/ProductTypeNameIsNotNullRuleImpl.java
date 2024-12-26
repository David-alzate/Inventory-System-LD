package co.inventory.system.ld.domain.products.rules.impl.producttype;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.products.exceptions.producttype.ProductTypeNameIsNullException;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeNameIsNotNullRule;

@Service
public class ProductTypeNameIsNotNullRuleImpl implements ProductTypeNameIsNotNullRule {

	@Override
	public void validate(String data) {
		if (TextHelper.isNull(data)) {
			throw ProductTypeNameIsNullException.create();
		}
	}
}
