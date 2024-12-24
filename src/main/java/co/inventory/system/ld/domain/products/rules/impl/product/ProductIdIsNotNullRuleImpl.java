package co.inventory.system.ld.domain.products.rules.impl.product;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.products.exceptions.product.ProductIdIsNullException;
import co.inventory.system.ld.domain.products.rules.product.ProductIdIsNotNullRule;

@Service
public class ProductIdIsNotNullRuleImpl implements ProductIdIsNotNullRule {

	@Override
	public void validate(UUID data) {

		if (ObjectHelper.isNull(data)) {
			throw ProductIdIsNullException.create();
		}
	}
}
