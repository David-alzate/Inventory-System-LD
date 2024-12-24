package co.inventory.system.ld.domain.products.rules.impl.producttype;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.repository.products.ProductTypeRepository;
import co.inventory.system.ld.domain.products.exceptions.product.ProductIdDoesExitsException;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeIdDoesNotExitsRule;

@Service
public class ProductTypedDoesNotExitsRuleImpl implements ProductTypeIdDoesNotExitsRule {

	private ProductTypeRepository productTypeRepository;

	public ProductTypedDoesNotExitsRuleImpl(ProductTypeRepository productTypeRepository) {
		super();
		this.productTypeRepository = productTypeRepository;
	}

	@Override
	public void validate(UUID data) {
		if (productTypeRepository.existsById(data)) {
			throw ProductIdDoesExitsException.create();
		}

	}

}
