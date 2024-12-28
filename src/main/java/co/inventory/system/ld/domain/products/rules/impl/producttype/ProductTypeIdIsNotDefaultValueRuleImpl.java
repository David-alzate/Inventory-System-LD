package co.inventory.system.ld.domain.products.rules.impl.producttype;

import java.util.UUID;

import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import co.inventory.system.ld.domain.products.exceptions.producttype.ProductTypeIdIsDefaultValueException;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeIdIsNotDefaultValueRule;

public class ProductTypeIdIsNotDefaultValueRuleImpl implements ProductTypeIdIsNotDefaultValueRule {

	@Override
	public void validate(UUID data) {
		if (UUIDHelper.isDefault(data)) {
			throw ProductTypeIdIsDefaultValueException.create();
		}

	}
}
