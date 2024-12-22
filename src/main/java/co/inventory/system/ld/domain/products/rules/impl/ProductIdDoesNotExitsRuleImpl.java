package co.inventory.system.ld.domain.products.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.repository.products.ProductsRepository;
import co.inventory.system.ld.domain.products.exceptions.ProductIdDoesExitsException;
import co.inventory.system.ld.domain.products.rules.ProductIdDoesNotExitsRule;

@Service
public class ProductIdDoesNotExitsRuleImpl implements ProductIdDoesNotExitsRule{
	
	private ProductsRepository productsRepository;
	
	public ProductIdDoesNotExitsRuleImpl(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	@Override
	public void validate(UUID data) {
		if(!productsRepository.existsById(data)) {
			throw ProductIdDoesExitsException.create();
		}
		
	}

}
