package co.inventory.system.ld.domain.products.rules.impl.producttype;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.products.exceptions.producttype.ProductTypeNameIsEmpyException;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeNameIsNotEmpyRule;

@Service
public class ProductTypeNameIsNotEmpyRuleImpl implements ProductTypeNameIsNotEmpyRule {

	@Override
	public void validate(String data) {
		if (TextHelper.isEmpty(data)) {
			throw ProductTypeNameIsEmpyException.create();
		}
	}
}
