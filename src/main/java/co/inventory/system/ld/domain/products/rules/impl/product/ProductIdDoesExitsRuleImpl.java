package co.inventory.system.ld.domain.products.rules.impl.product;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.repository.products.ProductsRepository;
import co.inventory.system.ld.domain.products.exceptions.product.ProductIdDoesNotExitsException;
import co.inventory.system.ld.domain.products.rules.product.ProductIdDoesExitsRule;

@Service
public class ProductIdDoesExitsRuleImpl implements ProductIdDoesExitsRule {

	private final ProductsRepository productsRepository;

	public ProductIdDoesExitsRuleImpl(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	@Override
	public void validate(UUID data) {
		if (!productsRepository.existsById(data)) {
			throw ProductIdDoesNotExitsException.create();
		}

	}

}
